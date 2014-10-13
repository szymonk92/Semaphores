/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monpie.histogram;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

/**
 *
 * @author Szymon
 */
public class OneThread implements Runnable {

    Multiset<String> histogram;

    @Override
    public void run() {
        histogram = HashMultiset.create();

        String randomArray[][] = RandomizeArray.array;

        for (int i = 0; i < RandomizeArray.ROWS; i++) {
            for (int j = 0; j < RandomizeArray.COLUMNS; j++) {
                histogram.add(randomArray[i][j]);
            }
        }

        for (String asciiCharacter : Multisets.copyHighestCountFirst(histogram).elementSet()) {
            System.out.println(asciiCharacter + " : " + histogram.count(asciiCharacter));
        }
        System.out.println("Sum of all elements: " + histogram.size());
    }

}
