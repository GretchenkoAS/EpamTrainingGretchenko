package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;

public class SentenceParser extends AbstractComponentParser{
    private AbstractComponentParser successor = new LexemeParser();
    private static final String LEXEME_SPLIT = "\\s";

    @Override
    public CompositeText parse(String text) {
        CompositeText sentence = new CompositeText(CompositeType.LEXEME);
        for (String lexemeText : text.split(LEXEME_SPLIT)) {
            CompositeText lexeme = successor.parse(lexemeText);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
