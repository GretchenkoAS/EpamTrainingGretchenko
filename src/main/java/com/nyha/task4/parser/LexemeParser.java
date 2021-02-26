package com.nyha.task4.parser;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;
import com.nyha.task4.composite.Symbol;
import com.nyha.task4.composite.SymbolType;

public class LexemeParser extends AbstractComponentParser{
    private static final String PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String REGEX_WORD_CHARACTER = "[\\wА-Яа-я]";

    @Override
    public CompositeText parse(String text) {
        CompositeText lexeme = new CompositeText(CompositeType.LEXEME);
        char[] lexemeChars = text.toCharArray();
        for (char lexemeChar : lexemeChars) {
            Symbol symbol = null;
            if (isPunctuation(lexemeChar)) {
                symbol = new Symbol(lexemeChar, SymbolType.PUNCTUATION);
            }
            if (isWordCharacter(lexemeChar)) {
                symbol = new Symbol(lexemeChar,
                        SymbolType.WORD_CHARACTER);
            }
            if (symbol != null) {
                lexeme.add(symbol);
            }
        }
        return lexeme;
    }

    private boolean isWordCharacter(char character) {
        String characterString = String.valueOf(character);
        return characterString.matches(REGEX_WORD_CHARACTER);
    }

    private boolean isPunctuation(char character) {
        String characterString = String.valueOf(character);
        return PUNCTUATION.contains(characterString);
    }
}
