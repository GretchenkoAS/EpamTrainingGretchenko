package test.nyha.task4.entity;

import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.composite.CompositeType;
import com.nyha.task4.composite.Symbol;
import com.nyha.task4.composite.SymbolType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CompositeTextTest {
    CompositeText sentence;
    @BeforeTest
    public void setUp() {
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        sentence = new CompositeText(CompositeType.SENTENCE);
        sentence.add(word1);
        sentence.add(word2);
    }

    @AfterClass
    public void tearDown() {
        sentence = null;
    }

    @Test
    public void countSymbolPositiveTest() {
        int expectedResult = 5;
        int actualResult = sentence.countSymbol();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void countSymbolNegativeTest() {
        int expectedResult = 4;
        int actualResult = sentence.countSymbol();
        assertNotEquals(actualResult, expectedResult);
    }
}
