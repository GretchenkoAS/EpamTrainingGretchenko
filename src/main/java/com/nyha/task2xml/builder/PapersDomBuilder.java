package com.nyha.task2xml.builder;

import com.nyha.task2xml.entity.*;
import com.nyha.task2xml.exeption.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

public class PapersDomBuilder extends AbstractPapersBuilder {
    static Logger logger = LogManager.getLogger();
    private static final String DEFAULT_LANGUAGE = "rus";
    private DocumentBuilder documentBuilder;

    public PapersDomBuilder() throws ParserException {
        this.papers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
            throw new ParserException("DOM parser error: ", e);
        }
    }


    @Override
    public void buildSetPapers(String fileName) throws ParserException {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList papersList = root.getChildNodes();
            for (int i = 0; i < papersList.getLength(); i++) {
                if (papersList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element paperElement = (Element) papersList.item(i);
                    Paper paper = buildPaper(paperElement);
                    papers.add(paper);
                }
            }
        } catch (IOException e) {
            logger.error("File error or I/O error: ", e);
            throw new ParserException("File error or I/O error: ", e);
        } catch (SAXException e) {
            logger.error("Parsing failure:  ", e);
            throw new ParserException("Parsing failure: ", e);
        }
    }

    private Paper buildPaper(Element paperElement) throws ParserException {
        Paper paper = null;
        if (paperElement.getTagName().equals(PaperXmlTag.ART_PAPER.getTag())) {
            paper = buildArtPaper(paperElement);
        }
        if (paperElement.getTagName().equals(PaperXmlTag.SCIENCE_PAPER.getTag())) {
            paper = buildSciencePaper(paperElement);
        }
        if (paper == null) {
            throw new ParserException("Error during build paper");
        }
        paper.setId(paperElement.getAttribute(PaperXmlTag.ID.getTag()));
        String language = paperElement.getAttribute(PaperXmlTag.LANGUAGE.getTag());
        if(language != null){
            paper.setLanguage(language);
        } else {
            paper.setLanguage(DEFAULT_LANGUAGE);
        }
        paper.setTitle(getElementTextContent(paperElement, PaperXmlTag.TITLE.getTag()));
        PaperType paperType = PaperType.getTypeByValue(
                getElementTextContent(paperElement, PaperXmlTag.TYPE.getTag())).get();
        paper.setType(paperType);
        String date = getElementTextContent(paperElement, PaperXmlTag.RELEASE_DATE.getTag());
        paper.setReleaseDate(LocalDate.parse(date));
        paper.setMonthly(Boolean.parseBoolean(
                getElementTextContent(paperElement, PaperXmlTag.MONTHLY.getTag())
        ));
        paper.setChars(buildChars(paperElement));
        return paper;
    }

    private Chars buildChars(Element paperElement) {
        Chars chars = new Chars();
        chars.setColored(Boolean.parseBoolean(
                getElementTextContent(paperElement, PaperXmlTag.COLORED.getTag())
        ));
        chars.setPages(Integer.parseInt(
                getElementTextContent(paperElement, PaperXmlTag.PAGES.getTag())
        ));
        String glossy = getElementTextContent(paperElement, PaperXmlTag.GLOSSY.getTag());
        if(glossy != null) {
            chars.setGlossy(Boolean.parseBoolean(glossy));
        }
        String subscribeIndex = getElementTextContent(paperElement, PaperXmlTag.SUBSCRIBE_INDEX.getTag());
        if(subscribeIndex != null) {
            chars.setSubscribeIndex(Integer.parseInt(subscribeIndex));
        }
        return chars;
    }

    private ArtPaper buildArtPaper(Element atrPaperElement) {
        ArtPaper artPaper = new ArtPaper();
        Assigment assigment = Assigment.getTypeByValue(
                getElementTextContent(atrPaperElement, PaperXmlTag.ASSIGMENT.getTag())).get();
        artPaper.setAssigment(assigment);
        return artPaper;
    }

    private SciencePaper buildSciencePaper(Element sciencePaperElement) {
        SciencePaper sciencePaper = new SciencePaper();
        sciencePaper.setAttestationOrganization(getElementTextContent(
                sciencePaperElement, PaperXmlTag.ATTESTATION_ORGANIZATION.getTag()));
        return sciencePaper;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        if (node != null) {
            return node.getTextContent();
        }
        return null;
    }
}
