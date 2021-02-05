package com.nyha.task2xml.builder;

import com.nyha.task2xml.entity.Paper;
import com.nyha.task2xml.exception.ParserException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPapersBuilder {
    protected Set<Paper> papers;

    public AbstractPapersBuilder() {
        this.papers = new HashSet<Paper>();
    }

    public AbstractPapersBuilder(Set<Paper> papers) {
        this.papers = papers;
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    abstract public void buildSetPapers(String fileName) throws ParserException;
}
