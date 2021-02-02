package com.nyha.task2xml.builder.implementation.sax;

import com.nyha.task2xml.builder.AbstractPaperBuilder;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import java.util.Set;

public class PapersSAXBuilder extends AbstractPaperBuilder {
    private PaperHandler paperHandler;
    private XMLReader reader;

    public PapersSAXBuilder() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        paperHandler =  new PlaneHandler();
        planes = new HashSet<>();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException exp){
            logger.error("Error while parsing " + exp);
        }
        reader.setContentHandler(handler);
    }

    public PapersSAXBuilder(Set<Paper> papers) {
        super(papers);
    }
}
