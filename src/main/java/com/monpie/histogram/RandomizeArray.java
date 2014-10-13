/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monpie.histogram;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Szymon
 */
public class RandomizeArray implements Runnable {

    static final int ROWS = 10;
    static final int COLUMNS = 100;

    static String array[][] = new String[ROWS][COLUMNS];
    static FileWriter fileWriter;

    public RandomizeArray() throws IOException {
        fileWriter = new FileWriter("random.txt");
    }

    @Override
    public void run() {

        try {
            //losowanie liczb
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    array[i][j] = RandomStringUtils.randomAscii(1);
                    System.out.println(array[i][j]);
                    fileWriter.write(array[i][j]);
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(RandomizeArray.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
