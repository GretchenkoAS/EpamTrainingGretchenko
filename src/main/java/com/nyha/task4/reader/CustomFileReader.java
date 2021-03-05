package com.nyha.task4.reader;

import com.nyha.task4.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    static Logger logger = LogManager.getLogger();

    public String read(String fileName) throws CustomException {
        Path path = Paths.get(fileName);
        if (Files.notExists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
            logger.error("resource exception" + fileName);
            throw new CustomException("resource exception" + fileName);
        }
        try {
            String data = new String(Files.readAllBytes(path));
            logger.info("File " + fileName + " was successfully read");
            return data;
        } catch (IOException e) {
            logger.error("io exception");
            throw new CustomException(e);
        }
    }
}
