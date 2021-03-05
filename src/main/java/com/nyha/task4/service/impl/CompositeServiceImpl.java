package com.nyha.task4.service.impl;

import com.nyha.task4.comparator.ComponentComparatorType;
import com.nyha.task4.composite.*;
import com.nyha.task4.exception.CustomException;
import com.nyha.task4.service.CompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CompositeServiceImpl implements CompositeService {
    static Logger logger = LogManager.getLogger();
    private static final String CONSONANTS = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZzйЙцЦкКнНгГшШщЩзЗхХфФвВпПрРлЛдДжЖчЧсСмМтТбБ";
    private static final String VOWELS = "AaEeYyUuIiOoёЁеЕыЫаАоОэЭУуяЯиИюЮ";

    @Override
    public List<ComponentText> sortParagraphsBySentenceNumber(CompositeText text) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        List<ComponentText> paragraphs =
                new ArrayList<>(text.getComponents());
        Comparator<ComponentText> comparator = ComponentComparatorType.COMPONENT_NUMBER.getComparator();
        paragraphs.sort(comparator);
        logger.info("Text was sorted");
        return paragraphs;
    }

    @Override
    public List<ComponentText> findSentencesWithLongestWord(CompositeText text) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        int longestWordLength = findLongestWordLength(text);
        List<ComponentText> sentences = new ArrayList<>();
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                Comparator<ComponentText> comparator = ComponentComparatorType.COMPONENT_NUMBER.getComparator();
                ComponentText longestWord = Collections.max(sentence.getComponents(), comparator);
                if (longestWord.countSymbol() == longestWordLength) {
                    sentences.add(sentence);
                }
            }
        }
        logger.info("Sentences were found");
        return sentences;
    }

    @Override
    public void removeSentencesBySpecificValue(CompositeText text, int number) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        List<ComponentText> sentencesToDelete = new ArrayList<>();
        List<ComponentText> paragraphsToDelete = new ArrayList<>();
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                if (sentence.getComponents().size() < number) {
                    sentencesToDelete.add(sentence);
                }
            }
            for (ComponentText sentence : sentencesToDelete) {
                if (paragraph.getComponents().size() != 1) {
                    paragraph.remove(sentence);
                } else {
                    paragraphsToDelete.add(paragraph);
                }
            }
            sentencesToDelete.removeAll(sentencesToDelete);
            if (paragraph.getComponents() == null) {
                paragraphsToDelete.add(paragraph);
            }
        }
        for (ComponentText paragraph : paragraphsToDelete) {
            text.remove(paragraph);
        }
        paragraphsToDelete.removeAll(paragraphsToDelete);
        logger.info("Sentences with fewer than " + number + " words have been removed");
    }

    @Override
    public Map<String, Integer> findIdenticalWords(CompositeText text) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        Map<String, Integer> identicalWords = new HashMap<>();
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                for (ComponentText lexeme : sentence.getComponents()) {
                    StringBuilder word = new StringBuilder();
                    for (ComponentText symbol : lexeme.getComponents()) {
                        if (((Symbol) symbol).getType() == SymbolType.WORD_CHARACTER) {
                            word.append(symbol.toString().toLowerCase());
                        }
                    }
                    Integer oldCount = identicalWords.get(word.toString());
                    if ( oldCount == null ) {
                        oldCount = 0;
                    }
                    identicalWords.put(word.toString(), oldCount + 1);
                }
            }
        }
        identicalWords.remove("");
        logger.info("Identical words were found");
        return identicalWords;
    }

    @Override
    public int findNumberOfVowels(CompositeText text) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        int numberOfVowels = 0;
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                for (ComponentText lexeme : sentence.getComponents()) {
                    for (ComponentText symbol : lexeme.getComponents()) {
                        if (isVowel(symbol.toString())) {
                            ++numberOfVowels;
                        }
                    }
                }
            }
        }
        return numberOfVowels;
    }

    @Override
    public int findNumberOfConsonants(CompositeText text) throws CustomException {
        if (text.getType() != CompositeType.TEXT) {
            logger.error("Composite is not text");
            throw new CustomException("Composite is not text");
        }
        int numberOfСonsonants = 0;
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                for (ComponentText lexeme : sentence.getComponents()) {
                    for (ComponentText symbol : lexeme.getComponents()) {
                        if (isConsonant(symbol.toString())) {
                            ++numberOfСonsonants;
                        }
                    }
                }
            }
        }
        return numberOfСonsonants;
    }

    private int findLongestWordLength(CompositeText text) {
        int length = 0;
        for (ComponentText paragraph : text.getComponents()) {
            for (ComponentText sentence : paragraph.getComponents()) {
                for (ComponentText word : sentence.getComponents()) {
                    if (word.countSymbol() > length) {
                        length = word.countSymbol();
                    }
                }
            }
        }
        return length;
    }

    private boolean isConsonant(String s) {
        return CONSONANTS.contains(s);
    }

    private boolean isVowel(String s) {
        return VOWELS.contains(s);
    }
}
