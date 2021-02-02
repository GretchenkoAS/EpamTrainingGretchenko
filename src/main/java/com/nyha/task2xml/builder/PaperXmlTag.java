package com.nyha.task2xml.builder;

public enum PaperXmlTag {
    PAPERS("papers"),
    ART_PAPER("art-paper"),
    SCIENCE_PAPER("science-paper"),
    ID("id"),
    LANGUAGE("language"),
    TITLE("title"),
    TYPE("type"),
    RELEASE_DATE("release-date"),
    MONTHLY("monthly"),
    CHARS("chars"),
    COLORED("colored"),
    PAGES("pages"),
    GLOSSY("glossy"),
    SUBSCRIBE_INDEX("subscribe-index"),
    ASSIGMENT("assigment"),
    ATTESTATION_ORGANIZATION("attestation-organization");

    private String tag;

    PaperXmlTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
