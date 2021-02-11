package com.nyha.task3shape.reader;

import com.nyha.task3shape.exeption.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    static Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String fileName) throws ShapeException {
        Path path = Paths.get(fileName);
        List<String> lines;
        if (Files.notExists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
            logger.error("resource exception" + fileName);
            throw new ShapeException("resource exception" + fileName);
        }
        try (Stream<String> stream = Files.lines(path)) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("io exception");
            throw new ShapeException(e);
        }
        logger.info("read string from file : " + lines);
        return lines;
    }
}