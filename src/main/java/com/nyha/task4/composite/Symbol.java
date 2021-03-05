package com.nyha.task4.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements ComponentText{
    static Logger logger = LogManager.getLogger();
    public static final int LENGHT_SIMBOL = 1;
    private char character;
    private SymbolType type;

    public Symbol(char character, SymbolType type) {
        this.character = character;
        this.type = type;
    }

    public char getCharacter() {
        return character;
    }

    public SymbolType getType() {
        return type;
    }

    @Override
    public void add(ComponentText component) {
        logger.error("Operation not supported for class symbol");
        throw new UnsupportedOperationException("Operation not supported for class symbol");

    }

    @Override
    public void remove(ComponentText component) {
        logger.error("Operation not supported for class symbol");
        throw new UnsupportedOperationException("Operation not supported for class symbol");
    }

    @Override
    public List<ComponentText> getComponents() {
        logger.error("Operation not supported for class symbol");
        throw new UnsupportedOperationException("Operation not supported for class symbol");
    }

    @Override
    public int countSymbol() {
        return LENGHT_SIMBOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol = (Symbol) o;
        if (character != symbol.character) {
            return false;
        }
        return type == symbol.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = character;
        result = prime * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
