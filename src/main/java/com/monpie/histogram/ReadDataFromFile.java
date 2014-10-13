/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monpie.histogram;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Szymon
 */
public class ReadDataFromFile implements Runnable {

    File file;
    FileReader fileReader;
    BufferedReader bufferedReader;
    static LinkedList<String> lines = Lists.newLinkedList();

    public ReadDataFromFile() {

    }

    @Override
    public void run() {

        file = new File(System.getProperty("user.dir") + "\\random.txt");
        System.getProperty("user.dir");
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String stringLines;
            while ((stringLines = bufferedReader.readLine()) != null) {
                lines.add(stringLines);
                System.out.println(stringLines);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
