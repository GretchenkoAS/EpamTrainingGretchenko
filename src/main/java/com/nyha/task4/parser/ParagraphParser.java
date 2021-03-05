package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;

public class ParagraphParser extends AbstractComponentParser{
    private static final String SENTENCE_SPLIT = "(?<=[!|?|.{1-3}]\\s)";
    private AbstractComponentParser successor = new SentenceParser();

    @Override
    public CompositeText parse(String text) {
        CompositeText paragraph = new CompositeText(CompositeType.PARAGRAPH);
        for (String sentenceText : text.split(SENTENCE_SPLIT)) {
            CompositeText sentence = successor.parse(sentenceText);
            paragraph.add(sentence);
        }
        return paragraph;
    }
}
