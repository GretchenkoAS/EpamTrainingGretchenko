package com.nyha.task2xml.builder;

import com.nyha.task2xml.entity.*;
import com.nyha.task2xml.exeption.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

public class PapersStaxBuilder extends AbstractPapersBuilder {
    static Logger logger = LogManager.getLogger();
    private static final String DEFAULT_LANGUAGE = "rus";
    private XMLInputFactory inputFactory;

    public PapersStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        papers = new HashSet<>();
    }

    @Override
    public void buildSetPapers(String fileName) throws ParserException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream fileInputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(fileInputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(PaperXmlTag.ART_PAPER.getTag())) {
                        Paper paper = buildPaper(reader, new ArtPaper());
                        papers.add(paper);
                    }
                    if (name.equals(PaperXmlTag.SCIENCE_PAPER.getTag())) {
                        Paper paper = buildPaper(reader, new SciencePaper());
                        papers.add(paper);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error("xmlStreamException or fileNotFoundException: ", e);
            throw new ParserException("xmlStreamException or fileNotFoundException: ", e);
        } catch (IOException e) {
            logger.error("ioexception: ", e);
            throw new ParserException("ioexception: ", e);
        }
    }

    private Paper buildPaper(XMLStreamReader reader, Paper paper) throws XMLStreamException, ParserException {
        paper.setId(reader.getAttributeValue(null, PaperXmlTag.ID.getTag()));
        String language = reader.getAttributeValue(null, PaperXmlTag.LANGUAGE.getTag());
        if (language != null) {
            paper.setLanguage(language);
        } else {
            paper.setLanguage(DEFAULT_LANGUAGE);
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperXmlTag.getTagByValue(name).get()) {
                        case TITLE -> paper.setTitle(getXMLText(reader));
                        case TYPE -> paper.setType(PaperType.getTypeByValue(getXMLText(reader)).get());
                        case RELEASE_DATE -> paper.setReleaseDate(LocalDate.parse(getXMLText(reader)));
                        case MONTHLY -> paper.setMonthly(Boolean.parseBoolean(getXMLText(reader)));
                        case CHARS -> paper.setChars(buildPaperChars(reader));
                        case ASSIGMENT -> ((ArtPaper) paper).setAssigment(
                                Assigment.getTypeByValue(getXMLText(reader)).get());
                        case ATTESTATION_ORGANIZATION -> ((SciencePaper) paper).setAttestationOrganization(
                                getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(PaperXmlTag.ART_PAPER.getTag())
                            || name.equals(PaperXmlTag.SCIENCE_PAPER.getTag())) {
                        return paper;
                    }
                    break;
            }
        }
        logger.warn("Unexpected tag during building paper");
        throw new ParserException("Unexpected tag");
    }

    private Chars buildPaperChars(XMLStreamReader reader) throws XMLStreamException, ParserException {
        Chars chars = new Chars();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperXmlTag.getTagByValue(name).get()) {
                        case COLORED -> chars.setColored(Boolean.parseBoolean(getXMLText(reader)));
                        case PAGES -> chars.setPages(Integer.parseInt(getXMLText(reader)));
                        case GLOSSY -> chars.setGlossy(Boolean.parseBoolean(getXMLText(reader)));
                        case SUBSCRIBE_INDEX -> chars.setSubscribeIndex(
                                Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals(PaperXmlTag.CHARS.getTag())) {
                        return chars;
                    }
                break;
            }
        }
        logger.warn("Unexpected tag during building paper chars");
        throw new ParserException("Unexpected tag");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
