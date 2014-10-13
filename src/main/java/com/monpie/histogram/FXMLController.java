package com.monpie.histogram;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    @FXML
    static Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            /*
             Create random array with ASCII cahracters
             
             RandomizeArray hipsta = new RandomizeArray();
             Thread thread = new Thread(hipsta);
             thread.start();
             thread.join();
             */

            /*
             Count elements using Multiset, only one thread.
             *
             long oneStart = System.currentTimeMillis();
             OneThread one = new OneThread();
             Thread oneThread = new Thread(one);
             oneThread.start();
             oneThread.join();
             long oneEnd = System.currentTimeMillis();
             long oneDelta = oneEnd - oneStart;

             /*
             Using hashMap. Only one thread.
             *
             long multiStart = System.currentTimeMillis();
             OneThreadHashMap oneThreadHashMap = new OneThreadHashMap();
             Thread countsThread = new Thread(oneThreadHashMap);
             countsThread.start();
             countsThread.join();
             long multiEnd = System.currentTimeMillis();
             long multiDelta = multiEnd - multiStart;

             System.out.println("Szybsza pojedyncza nitka o " + ((multiDelta - oneDelta) / 1000.0));
             */
            ReadDataFromFile readData = new ReadDataFromFile();
            Thread readThread = new Thread(readData);
            readThread.start();
            readThread.join();

            MultiThread multi = new MultiThread();
            Thread multiThreas = new Thread(multi);
            multiThreas.start();
            multiThreas.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
//            catch (IOException ex) {
//            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
