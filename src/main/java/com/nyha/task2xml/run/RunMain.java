package com.nyha.task2xml.run;

import com.nyha.task2xml.builder.AbstractPapersBuilder;
import com.nyha.task2xml.entity.Paper;
import com.nyha.task2xml.exeption.ParserException;
import com.nyha.task2xml.factory.PaperBuilderFactory;

import java.util.HashSet;
import java.util.Set;

public class RunMain {
    public static void main(String[] args) throws ParserException {
        String type = "SAX";
        AbstractPapersBuilder builder = PaperBuilderFactory.createPaperBuilder(type);
        builder.buildSetPapers("data/periodical.xml");
        Set<Paper> papers = new HashSet<>();
        System.out.println(builder.getPapers());
    }
}
