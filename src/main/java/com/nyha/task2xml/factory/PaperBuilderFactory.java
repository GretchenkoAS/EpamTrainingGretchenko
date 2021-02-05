package com.nyha.task2xml.factory;

import com.nyha.task2xml.builder.AbstractPapersBuilder;
import com.nyha.task2xml.builder.PapersDomBuilder;
import com.nyha.task2xml.builder.PapersSaxBuilder;
import com.nyha.task2xml.builder.PapersStaxBuilder;
import com.nyha.task2xml.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaperBuilderFactory {
    static Logger logger = LogManager.getLogger();
    private enum TypeParser {
        SAX, STAX, DOM
    }
    private PaperBuilderFactory() {
    }
    public static AbstractPapersBuilder createPaperBuilder(String typeParser) throws ParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        logger.info("Creating " + type + " parser");
        switch (type) {
            case SAX -> {
                return new PapersSaxBuilder();
            }
            case DOM -> {
                return new PapersDomBuilder();
            }
            case STAX -> {
                return new PapersStaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
