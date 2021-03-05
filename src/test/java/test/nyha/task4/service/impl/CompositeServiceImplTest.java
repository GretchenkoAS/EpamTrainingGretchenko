package test.nyha.task4.service.impl;

import com.nyha.task4.composite.*;
import com.nyha.task4.exception.CustomException;
import com.nyha.task4.service.impl.CompositeServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CompositeServiceImplTest {
    CompositeServiceImpl service;
    CompositeText text;

    @BeforeClass
    public void setUp() {
        service = new CompositeServiceImpl();
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        CompositeText sentence1 = new CompositeText(CompositeType.SENTENCE);
        sentence1.add(word1);
        sentence1.add(word2);
        CompositeText sentence2 = new CompositeText(CompositeType.SENTENCE);
        sentence2.add(word1);
        sentence2.add(word2);
        sentence2.add(word3);
        CompositeText sentence3 = new CompositeText(CompositeType.SENTENCE);
        sentence3.add(word5);
        sentence3.add(word2);
        CompositeText sentence4 = new CompositeText(CompositeType.SENTENCE);
        sentence4.add(word1);
        sentence4.add(word2);
        sentence4.add(word3);
        sentence4.add(word4);
        sentence4.add(word5);
        CompositeText sentence5 = new CompositeText(CompositeType.SENTENCE);
        sentence5.add(word1);
        CompositeText paragraph1 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        paragraph1.add(sentence3);
        CompositeText paragraph2 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph2.add(sentence4);
        paragraph2.add(sentence5);
        text = new CompositeText(CompositeType.TEXT);
        text.add(paragraph1);
        text.add(paragraph2);
    }

    @AfterClass
    public void tearDown() {
        service = null;
        text = null;
    }

    @Test
    public void sortParagraphsBySentenceNumberPositiveTest() throws CustomException {
        List<ComponentText> actual = service.sortParagraphsBySentenceNumber(text);
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        CompositeText sentence1 = new CompositeText(CompositeType.SENTENCE);
        sentence1.add(word1);
        sentence1.add(word2);
        CompositeText sentence2 = new CompositeText(CompositeType.SENTENCE);
        sentence2.add(word1);
        sentence2.add(word2);
        sentence2.add(word3);
        CompositeText sentence3 = new CompositeText(CompositeType.SENTENCE);
        sentence3.add(word5);
        sentence3.add(word2);
        CompositeText sentence4 = new CompositeText(CompositeType.SENTENCE);
        sentence4.add(word1);
        sentence4.add(word2);
        sentence4.add(word3);
        sentence4.add(word4);
        sentence4.add(word5);
        CompositeText sentence5 = new CompositeText(CompositeType.SENTENCE);
        sentence5.add(word1);
        CompositeText paragraph1 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        paragraph1.add(sentence3);
        CompositeText paragraph2 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph2.add(sentence4);
        paragraph2.add(sentence5);
        List<ComponentText> expected = new ArrayList<>();
        expected.add(paragraph2);
        expected.add(paragraph1);
        assertEquals(expected, actual);
    }

    @Test
    public void sortParagraphsBySentenceNumberNegativeTest() throws CustomException {
        List<ComponentText> actual = service.sortParagraphsBySentenceNumber(text);
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        CompositeText sentence1 = new CompositeText(CompositeType.SENTENCE);
        sentence1.add(word1);
        sentence1.add(word2);
        CompositeText sentence2 = new CompositeText(CompositeType.SENTENCE);
        sentence2.add(word1);
        sentence2.add(word2);
        sentence2.add(word3);
        CompositeText sentence3 = new CompositeText(CompositeType.SENTENCE);
        sentence3.add(word5);
        sentence3.add(word2);
        CompositeText sentence4 = new CompositeText(CompositeType.SENTENCE);
        sentence4.add(word1);
        sentence4.add(word2);
        sentence4.add(word3);
        sentence4.add(word4);
        sentence4.add(word5);
        CompositeText sentence5 = new CompositeText(CompositeType.SENTENCE);
        sentence5.add(word1);
        CompositeText paragraph1 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        paragraph1.add(sentence3);
        CompositeText paragraph2 = new CompositeText(CompositeType.PARAGRAPH);
        paragraph2.add(sentence4);
        List<ComponentText> expected = new ArrayList<>();
        expected.add(paragraph1);
        expected.add(paragraph2);
        assertNotEquals(expected, actual);
    }

    @Test
    public void findSentencesWithLongestWordPositiveTest() throws CustomException {
        List<ComponentText> actual = service.findSentencesWithLongestWord(text);
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        CompositeText sentence3 = new CompositeText(CompositeType.SENTENCE);
        sentence3.add(word5);
        sentence3.add(word2);
        CompositeText sentence4 = new CompositeText(CompositeType.SENTENCE);
        sentence4.add(word1);
        sentence4.add(word2);
        sentence4.add(word3);
        sentence4.add(word4);
        sentence4.add(word5);
        List<ComponentText> expected = new ArrayList<>();
        expected.add(sentence3);
        expected.add(sentence4);
        assertEquals(expected, actual);
    }

    @Test
    public void findSentencesWithLongestWordNegativeTest() throws CustomException {
        List<ComponentText> actual = service.findSentencesWithLongestWord(text);
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        CompositeText sentence4 = new CompositeText(CompositeType.SENTENCE);
        sentence4.add(word1);
        sentence4.add(word2);
        sentence4.add(word3);
        sentence4.add(word4);
        sentence4.add(word5);
        List<ComponentText> expected = new ArrayList<>();
        expected.add(sentence4);
        assertNotEquals(expected, actual);
    }

    @Test
    public void findIdenticalWordsPositiveTest() throws CustomException {
        Map<String,Integer> actual = service.findIdenticalWords(text);
        Map<String, Integer> expected = new HashMap<>();
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        expected.put(word1.toString(), 4);
        expected.put(word2.toString(), 4);
        expected.put(word3.toString(), 2);
        expected.put(word4.toString(), 1);
        expected.put(word5.toString(), 2);
        assertEquals(expected, actual);
    }

    @Test
    public void findIdenticalWordsNegativeTest() throws CustomException {
        Map<String,Integer> actual = service.findIdenticalWords(text);
        Map<String, Integer> expected = new HashMap<>();
        Symbol symbol1 = new Symbol('1', SymbolType.WORD_CHARACTER);
        Symbol symbol2 = new Symbol('2', SymbolType.WORD_CHARACTER);
        Symbol symbol3 = new Symbol('3', SymbolType.WORD_CHARACTER);
        Symbol symbol4 = new Symbol('4', SymbolType.WORD_CHARACTER);
        Symbol symbol5 = new Symbol('5', SymbolType.WORD_CHARACTER);
        Symbol symbol6 = new Symbol('6', SymbolType.WORD_CHARACTER);
        Symbol symbol7 = new Symbol('7', SymbolType.WORD_CHARACTER);
        Symbol symbol8 = new Symbol('8', SymbolType.WORD_CHARACTER);
        Symbol symbol9 = new Symbol('9', SymbolType.WORD_CHARACTER);
        Symbol symbol10 = new Symbol('0', SymbolType.WORD_CHARACTER);
        CompositeText word1 = new CompositeText(CompositeType.LEXEME);
        word1.add(symbol1);
        word1.add(symbol2);
        CompositeText word2 = new CompositeText(CompositeType.LEXEME);
        word2.add(symbol3);
        word2.add(symbol4);
        word2.add(symbol5);
        CompositeText word3 = new CompositeText(CompositeType.LEXEME);
        word3.add(symbol6);
        CompositeText word4 = new CompositeText(CompositeType.LEXEME);
        word4.add(symbol7);
        CompositeText word5 = new CompositeText(CompositeType.LEXEME);
        word5.add(symbol8);
        word5.add(symbol9);
        word5.add(symbol10);
        word5.add(symbol10);
        expected.put(word1.toString(), 5);
        expected.put(word2.toString(), 4);
        expected.put(word3.toString(), 2);
        expected.put(word4.toString(), 1);
        expected.put(word5.toString(), 2);
        assertNotEquals(expected, actual);
    }

    @Test
    public void findNumberOfVowelsPositiveTest() throws CustomException {
        int actual = service.findNumberOfVowels(text);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void findNumberOfVowelsNegativeTest() throws CustomException {
        int actual = service.findNumberOfVowels(text);
        int expected = 1;
        assertNotEquals(expected, actual);
    }

    @Test
    public void findNumberOfConsonantsPositiveTest() throws CustomException {
        int actual = service.findNumberOfConsonants(text);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void findNumberOfConsonantsNegativeTest() throws CustomException {
        int actual = service.findNumberOfConsonants(text);
        int expected = 1;
        assertNotEquals(expected, actual);
    }
}
