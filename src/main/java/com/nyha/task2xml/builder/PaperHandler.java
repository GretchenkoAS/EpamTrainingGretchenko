package com.nyha.task2xml.builder;

import com.nyha.task2xml.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PaperHandler extends DefaultHandler {
    static Logger logger = LogManager.getLogger();
    private Set<Paper> papers;
    private Paper current;
    private PaperXmlTag currentTag;
    private EnumSet<PaperXmlTag> elementWithText;
    private static final String ID_REGEX = "\\w\\d{1,5}";
    private static final String DEFAULT_LANGUAGE = "rus";
    private static final int MAX_ATTRIBUTES_NUMBER = 2;

    public PaperHandler() {
        papers = new HashSet<Paper>();
        elementWithText = EnumSet.range(PaperXmlTag.ID, PaperXmlTag.ATTESTATION_ORGANIZATION);
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (PaperXmlTag.ART_PAPER.getTag().equals(qName) || PaperXmlTag.SCIENCE_PAPER.getTag().equals(qName)) {
            if (PaperXmlTag.ART_PAPER.getTag().equals(qName)) {
                current = new ArtPaper();
            }
            if (PaperXmlTag.SCIENCE_PAPER.getTag().equals(qName)) {
                current = new SciencePaper();
            }

            String stringAttribute = attributes.getValue(0);
            if (attributes.getLength() == MAX_ATTRIBUTES_NUMBER) {
                if(stringAttribute.matches(ID_REGEX)){
                    current.setId(stringAttribute);
                    stringAttribute = attributes.getValue(1);
                    current.setLanguage(stringAttribute);
                } else {
                    current.setLanguage(stringAttribute);
                    stringAttribute = attributes.getValue(1);
                    current.setId(stringAttribute);
                }
            } else {
                current.setId(stringAttribute);
                current.setLanguage(DEFAULT_LANGUAGE);
            }
        } else {
            PaperXmlTag temp = PaperXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if (elementWithText.contains(temp)) {
                currentTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (PaperXmlTag.ART_PAPER.getTag().equals(qName) || PaperXmlTag.SCIENCE_PAPER.getTag().equals(qName)) {
            papers.add(current);
            logger.info("element added");
        }
    }

    public void characters(char[] ch, int start, int length) {
        String tagText = new String(ch, start, length).strip();
        if (currentTag!= null) {
            switch (currentTag) {
                case ID -> current.setId(tagText);
                case LANGUAGE -> current.setLanguage(tagText);
                case TITLE -> current.setTitle(tagText);
                case TYPE -> current.setType(PaperType.getTypeByValue(tagText).get());
                case RELEASE_DATE -> current.setReleaseDate(LocalDate.parse(tagText));
                case MONTHLY -> current.setMonthly(Boolean.parseBoolean(tagText));
                case CHARS -> current.setChars(new Chars());
                case COLORED -> current.getChars().setColored(Boolean.parseBoolean(tagText));
                case PAGES -> current.getChars().setPages(Integer.parseInt(tagText));
                case GLOSSY -> current.getChars().setGlossy(Boolean.parseBoolean(tagText));
                case SUBSCRIBE_INDEX -> current.getChars().setSubscribeIndex(Integer.parseInt(tagText));
                case ASSIGMENT -> ((ArtPaper) current).setAssigment(Assigment.getTypeByValue(tagText).get());
                case ATTESTATION_ORGANIZATION -> ((SciencePaper) current).setAttestationOrganization(tagText);
                default -> {
                    logger.warn("Unknown tag");
                    throw new EnumConstantNotPresentException(
                            currentTag.getDeclaringClass(), currentTag.name());
                }
            }
        }
        currentTag = null;
    }
}
