package com.nyha.task4.service;

import com.nyha.task4.composite.ComponentText;
import com.nyha.task4.composite.CompositeText;
import com.nyha.task4.exception.CustomException;

import java.util.List;
import java.util.Map;

public interface CompositeService {
    List<ComponentText> sortParagraphsBySentenceNumber(CompositeText text) throws CustomException;
    List<ComponentText> findSentencesWithLongestWord(CompositeText text) throws CustomException;
    void removeSentencesBySpecificValue(CompositeText text, int number) throws CustomException;
    Map<String, Integer> findIdenticalWords(CompositeText text) throws CustomException;
    int findNumberOfVowels(CompositeText text) throws CustomException;
    int findNumberOfConsonants(CompositeText text) throws CustomException;
}
