package org.example;

import org.example.commonTools.CesarCipherFileCreator;

public class Main {
    public static void main(String[] args) {
       // "c:/MyProject/target/myApp.jar DECRYPT folder/textFile1[ENCRYPTED].txt 20"
        CesarCipherFileCreator cesarCipherFileCreator = new CesarCipherFileCreator();
        cesarCipherFileCreator.createCesarCipherFile("c:/MyProject/target/myApp.jar enCRYPT c:/test/testNote.txt 0");
        cesarCipherFileCreator.createCesarCipherFile("c:/MyProject/target/myApp.jar deCRYPT c:/test/testNote[ENCRYPTED].txt 0");
    }
}