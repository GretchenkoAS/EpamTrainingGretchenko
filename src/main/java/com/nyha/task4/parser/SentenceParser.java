package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;

public class SentenceParser extends AbstractComponentParser{
    private static final String LEXEME_SPLIT = "\\s";
    private AbstractComponentParser successor = new LexemeParser();

    @Override
    public CompositeText parse(String text) {
        CompositeText sentence = new CompositeText(CompositeType.SENTENCE);
        for (String lexemeText : text.split(LEXEME_SPLIT)) {
            CompositeText lexeme = successor.parse(lexemeText);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
