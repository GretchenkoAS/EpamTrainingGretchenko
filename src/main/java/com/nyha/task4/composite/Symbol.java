package com.nyha.task4.composite;

public class Symbol implements ComponentText{
    public static final int LENGHT_SIMBOL = 1;
    private final char character;
    private final SymbolType type;

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
        throw new UnsupportedOperationException("Operation not supported for class symbol");

    }

    @Override
    public void remove(ComponentText component) {
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
