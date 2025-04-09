package org.example.commonTools;

import org.example.coderInstruments.Coder;

public class CesarCipherFileCreator {

    public void createCesarCipherFile(String inputData) {
        InputDataAnalyzer analyzer = new InputDataAnalyzer(inputData);
        ProcessingFileService fileService = new ProcessingFileService(analyzer.getFilePath());
        Coder coder = new Coder(fileService.getFileData(), analyzer.getActionType(), analyzer.getPushValue());
        fileService.createCipherFile(coder.createChipher());
    }
}
