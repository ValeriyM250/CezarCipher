package org.example.commonTools;

import org.example.Exceptions.CreatingFileException;
import org.example.Exceptions.FileWritingException;
import org.example.Exceptions.WrongTypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ProcessingFileService {
    private final Path pathToFile;

    public ProcessingFileService(Path pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<String> getFileData() {
        List<String> dataFromFile;
        try {
            Files.isDirectory(pathToFile);
            dataFromFile = Files.readAllLines(pathToFile);
        } catch (IOException e) {
            throw new WrongTypeException("Element: " + pathToFile.getFileName()
                    + "  - is not type .txt, or is directory. You should check PATH to this file or filename");
        }
        return dataFromFile;
    }

    public void createCipherFile(List<String> dataToWrite) {
        Path newFileAddress = createNewAddress();
        try {
            if (!Files.exists(newFileAddress)) {
                Files.createFile(newFileAddress);
            }
        } catch (IOException e) {
            throw new CreatingFileException("Can`t create file: " + newFileAddress.getFileName());
        }

        try {
            for (String str : dataToWrite) {
                Files.writeString(newFileAddress, str + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new FileWritingException("Error writing file, something went wrong on writing stage");
        }
    }

    private Path createNewAddress() {
        String temp = pathToFile.toString().replaceAll(".txt", "");
        if (temp.toUpperCase().contains("ENCRYPTED")) {
            temp = temp.replaceAll("ENCRYPTED", "DECRYPTED");
        } else {
            temp += "[ENCRYPTED]";
        }
        temp += ".txt";
        return  Path.of(temp);
    }
}
