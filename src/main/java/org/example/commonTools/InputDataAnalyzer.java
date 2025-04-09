package org.example.commonTools;

import java.nio.file.Path;

public class InputDataAnalyzer {
    private final String [] inputParameters;
    //devideInput[0] - Path to jar.
    //devideInput[1] - action type ENCRYPT/DECRYPT
    //devideInput[2] - path to file
    //devideInput[3] - push Value


    public InputDataAnalyzer(String parameterString) {
        inputParameters = parameterString.split(" ");
    }

    public String getJarPath() {
        return inputParameters[0];
    }

    public String getActionType() {
        inputParameters[1] = inputParameters[1].replaceAll("]\\[", "").toUpperCase();
        return inputParameters[1];
    }

    public Path getFilePath() {
        return Path.of(inputParameters[2]);
    }

    public String getPushValue() {
        return inputParameters[3];
    }
}
