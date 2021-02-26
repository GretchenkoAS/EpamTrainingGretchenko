package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;

public class ParagraphParser extends AbstractComponentParser{
    private AbstractComponentParser successor = new SentenceParser();
    private static final String SENTENCE_SPLIT = "(?<=[!|?|.{1-3}]\\s)";

    @Override
    public CompositeText parse(String text) {
        CompositeText paragraph = new CompositeText(CompositeType.SENTENCE);
        for (String sentenceText : text.split(SENTENCE_SPLIT)) {
            CompositeText sentence = successor.parse(sentenceText);
            paragraph.add(sentence);
        }
        return paragraph;
    }
}

//= "[A-ZА-Я][^.?!]+[.?!]+";
