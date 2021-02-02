package com.nyha.task2xml.builder;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPaperBuilder {
    protected Set<Paper> papers;

    public AbstractPaperBuilder() {
        this.papers = new HashSet<Paper>();
    }

    public AbstractPaperBuilder(Set<Paper> papers) {
        this.papers = papers;
    }

    public Set<Paper> getPapers(Set<Paper> papers) {
        return this.papers;
    }

    abstract public void buildSetPapers(String filename);
}
