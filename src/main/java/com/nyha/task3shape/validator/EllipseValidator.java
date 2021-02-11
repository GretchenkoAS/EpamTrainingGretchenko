package com.nyha.task3shape.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipseValidator {
    static Logger logger = LogManager.getLogger();
    private static final String REGEX_COORDINATE = "[+-]?\\d+";
    private static final String FIGURE = "Ellipse";
    private static final String SPACE = "\\s";
    private static final String REGEX_ELLIPSE = FIGURE + ":" +
            SPACE + REGEX_COORDINATE + SPACE + REGEX_COORDINATE + SPACE +
            REGEX_COORDINATE + SPACE + REGEX_COORDINATE;

    public boolean isEllipseData(String data) {
        boolean result = data.matches(REGEX_ELLIPSE);
        logger.debug("Data was checked. Result: " + result);
        return result;
    }
}