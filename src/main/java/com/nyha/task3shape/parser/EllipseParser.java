package com.nyha.task3shape.parser;

import com.nyha.task3shape.exeption.ShapeException;
import com.nyha.task3shape.validator.EllipseValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EllipseParser {
    static Logger logger = LogManager.getLogger();
    private static final String REGEX_DELIMITER = "\\s+";

    public List<List<Integer>> parseLineToEllipse(List<String> lines) throws ShapeException {
        List<List<Integer>> ellipsesData = new ArrayList<>();
        EllipseValidator validator = new EllipseValidator();
        for (String line : lines) {
            if (validator.isEllipseData(line)) {
                List<Integer> coordinates = takeCoordinatesFromLine(line);
                ellipsesData.add(coordinates);
            }
        }
        logger.debug("Data was parsing successful.");
        return ellipsesData;
    }

    private List<Integer> takeCoordinatesFromLine(String line) throws ShapeException {
        List<Integer> coordinates = new ArrayList<>();
        List<String> strings = Arrays.asList(line.split(REGEX_DELIMITER));
        try {
            for (int i = 1; i < strings.size(); i++) {
                coordinates.add(Integer.parseInt(strings.get(i)));
            }
        } catch (NumberFormatException e) {
            logger.error("Parser error");
            throw new ShapeException("Parser error", e);
        }
        return coordinates;
    }
}
