package com.example.demojavafx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.io.IOException;



public class SendReqController implements Initializable {

    @FXML
    private TextArea textAreaUI;
    static TextArea staticTxtArea;


    @FXML
    void FilterClicked(MouseEvent event) throws IOException {
        System.out.println("FilterClicked");
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters()
                .addAll(
                        new FileChooser.ExtensionFilter("LOG files (*.LOG)", "*.LOG"),
                        new FileChooser.ExtensionFilter("log files (*.log)", "*.log")

                );
        File file = fileChooser.showOpenDialog(null);
        System.out.println(" - File Directory  :  " + file);

        Path path = Paths.get(file.toURI());

        long lineCount = Files.lines(path).count();

        int i = 0;
        int j = 1;

        while (i < lineCount) {

            String lineAll = Files.readAllLines(Paths.get(file.toURI())).get(i);
            String[] splitLine = lineAll.split("/");
            String[] doubleSplit = splitLine[0].split(" ");
            String[] tripleSplit = doubleSplit[3].split(":");

            if (j >= lineCount) j = i;

            String lineAll2 = Files.readAllLines(Paths.get(file.toURI())).get(j);
            String[] splitLine2 = lineAll2.split("/");
            String[] doubleSplit2 = splitLine2[0].split(" ");
            String[] tripleSplit2 = doubleSplit2[3].split(":");

            if (doubleSplit[3].startsWith("Send")) {

                if (tripleSplit[1].equals(tripleSplit2[1]) && !tripleSplit[0].equals(tripleSplit2[0]) && (i != j)) {
//                    System.out.println("true");
                } else {
                    if( i == j ) {
                        System.out.println(doubleSplit[3]);
                    } else {
                        System.out.println(doubleSplit[3]);
                        System.out.println(doubleSplit2[3]);
                    }
                }
            } else {
                i -= 3;
                j -= 3;
            }

            i += 2;
            j += 2;

        }

        System.out.println(" - Number of Line : "+lineCount);

    }

    @FXML
    void SearchClicked(MouseEvent event) throws IOException {
        FilterClicked(event);


//        System.err.println("@@@ERROR: This is error");
        System.out.println("####OUTPUT");
        //generating an exception to print on console
        try {
            int y = 0;
//            int x = 5 / y;

            if (y != 0) { // if 조건문 추가
                int x = 5 / y;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            // System.out.println(ex.getMessage());

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        staticTxtArea = textAreaUI;
    }
}
