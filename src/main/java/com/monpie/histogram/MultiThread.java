/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monpie.histogram;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Szymon
 */
public class MultiThread implements Runnable {

    private static final int NUMBER_OF_THREADS = 3;

    HashMap<String, AtomicInteger> asciiMap = Maps.newHashMap();
    LinkedList<String> asciiLines = ReadDataFromFile.lines;
    Semaphore semaphore = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);

    @Override
    public void run() {

        Calculate calculate = new Calculate();
//        Thread first = new Thread(calculate, "First");
//        first.start();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread(calculate, ("Thread" + i)).start();
        }
    }

    public class Calculate implements Runnable {

        public Calculate() {
        }

        @Override
        public void run() {

            for (int i = 0; i < asciiLines.size(); i++) {
                try {
                    semaphore.acquire();
                    // semaphore? lock?
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (String oneCharacter : asciiLines.get(i).split("")) {
                    if (asciiMap.containsKey(oneCharacter)) {
                        asciiMap.replace(oneCharacter, new AtomicInteger(asciiMap.get(oneCharacter).incrementAndGet()));
                    } else {
                        asciiMap.put(oneCharacter, new AtomicInteger(1));
                    }
                }
                semaphore.release();
            }

            int sum = 0;
            for (Map.Entry<String, AtomicInteger> entry : asciiMap.entrySet()) {
                System.out.println("Znak: " + entry.getKey() + " , ilosc powtorzen: " + entry.getValue());
                sum = sum + entry.getValue().get();
            }
            System.out.println("Sum of all elements: " + sum);

        }
    }

}
