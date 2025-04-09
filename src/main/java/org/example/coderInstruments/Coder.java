package org.example.coderInstruments;

import org.example.Exceptions.WrongActionException;

import java.util.ArrayList;
import java.util.List;

public class Coder {
    private static final String MASK = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            ".,«»'\"\\:!? ");

    private List<String> dataFromFile = new ArrayList<>();
    private String action; //[ENCRYPT, DECRYPT, BRUTE_FORCE]
    private String pushNumber;

    public Coder(List<String> data, String action, String pushNumber) {
        this.dataFromFile = data;
        this.pushNumber = pushNumber;
        if (pushNumber == null) {

        }
        this.action = action;
    }

    public List<String> createChipher() {
        switch (action.toUpperCase()) {
            case "DECRYPT":
                pushNumber = String.valueOf(Integer.valueOf(pushNumber) * -1);
            case "ENCRYPT" :
                    rewindDataStrings();
                    break;
                case "BRUTE_FORCE" :
                bruteForce();
                break;
            default:
                throw new WrongActionException("You entered wrong action to do, " +
                    "check your action [ENCRYPT, DECRYPT, BRUTE_FORCE]");
        }
        return getCipherData();
    }

    private void rewindDataStrings() { // private
        for (int i = 0; i < dataFromFile.size(); i++) {
            dataFromFile.set(i, revindCharArray(dataFromFile.get(i)));
        }
    }

    private String revindCharArray(String input) { // private
        char[] inputArray = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            result.append(getEncodedChar(inputArray[i]));
        }
        return result.toString();
    }

    private char getEncodedChar(char input) {
        int pushDigit = Integer.valueOf(pushNumber);
        String longerMask = MASK + MASK;

        if (MASK.indexOf(input) == -1)
            return input;

        if (Math.abs(pushDigit) > MASK.length()) {
            pushDigit = pushDigit % MASK.length();
        }
        if (pushDigit < 0) {                                    // encode negative value
            longerMask = new StringBuilder(longerMask).reverse().toString();
            pushDigit = longerMask.indexOf(input) + Math.abs(pushDigit);
        } else {                                                // encode positive value
            pushDigit += MASK.indexOf(input);
        }
        return longerMask.charAt(pushDigit);
    }

     private void bruteForce() {

     }

     private List<String> getCipherData() {
        return dataFromFile;
     }
}