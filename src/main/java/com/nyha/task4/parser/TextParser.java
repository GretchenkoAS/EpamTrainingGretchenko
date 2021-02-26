package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;

public class TextParser extends AbstractComponentParser{
    private AbstractComponentParser successor = new ParagraphParser();
    private static final String PARAGRAPH_SPLIT = "\\s{4}";

    @Override
    public CompositeText parse(String text) {
        CompositeText compositeText = new CompositeText(CompositeType.TEXT);
        for (String paragraphText : text.split(PARAGRAPH_SPLIT)) {
            CompositeText paragraph = successor.parse(paragraphText);
            compositeText.add(paragraph);
        }
        return compositeText;
    }
}