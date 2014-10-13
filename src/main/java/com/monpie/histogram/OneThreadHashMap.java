/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monpie.histogram;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Szymon
 */
public class OneThreadHashMap implements Runnable {

    HashMap<String, AtomicInteger> asciiMap;

    @Override
    public void run() {

        asciiMap = Maps.newHashMap();
        String randomArray[][] = RandomizeArray.array;

        for (int i = 0; i < RandomizeArray.ROWS; i++) {
            for (int j = 0; j < RandomizeArray.COLUMNS; j++) {
                if (asciiMap.containsKey(randomArray[i][j])) {
                    asciiMap.replace(randomArray[i][j], new AtomicInteger(asciiMap.get(randomArray[i][j]).incrementAndGet()));
                    System.out.println("element: " + randomArray[i][j]);
                } else {
                    asciiMap.put(randomArray[i][j], new AtomicInteger(1));
                }
            }
        }

        int sum = 0;
        for (Map.Entry<String, AtomicInteger> entry : asciiMap.entrySet()) {
            System.out.println("Znak: " + entry.getKey() + " , ilosc powtorzen: " + entry.getValue());
            sum = sum + entry.getValue().get();
        }
        System.out.println("Sum of all elements: " + sum);
    }

}
