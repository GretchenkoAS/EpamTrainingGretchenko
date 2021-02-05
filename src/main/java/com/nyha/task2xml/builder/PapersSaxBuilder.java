package com.nyha.task2xml.builder;

import com.nyha.task2xml.entity.Paper;
import com.nyha.task2xml.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PapersSaxBuilder extends AbstractPapersBuilder {
    static Logger logger = LogManager.getLogger();
    private PaperHandler paperHandler;
    private XMLReader reader;

    public PapersSaxBuilder() throws ParserException{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        paperHandler =  new PaperHandler();
        papers = new HashSet<>();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e){
            logger.error("SAX parser error: " + e);
            throw new ParserException("SAX parser error: ", e);
        }
        reader.setContentHandler(paperHandler);
    }

    public PapersSaxBuilder(Set<Paper> papers) {
        super(papers);
    }

    @Override
    public void buildSetPapers(String fileName) throws ParserException{
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.error("SAX parser build error " + e);
            throw new ParserException("SAX parser build error: ", e);
        }
        papers = paperHandler.getPapers();
    }
}
