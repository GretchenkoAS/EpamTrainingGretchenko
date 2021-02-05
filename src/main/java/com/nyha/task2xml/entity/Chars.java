package com.nyha.task2xml.entity;

public class Chars {
    private boolean colored;
    private int pages;
    private boolean glossy;
    private int subscribeIndex;

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    public int getSubscribeIndex() {
        return subscribeIndex;
    }

    public void setSubscribeIndex(int subscribeIndex) {
        this.subscribeIndex = subscribeIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Chars other = (Chars) obj;
        if (colored != other.colored){
            return false;
        }
        if (pages != other.pages){
            return false;
        }
        if (glossy != other.glossy){
            return false;
        }
        if (subscribeIndex != other.subscribeIndex){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (colored ? 1 : 0);
        result = prime * result + pages;
        result = prime * result + (glossy ? 1 : 0);
        result = prime * result + subscribeIndex;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chars{");
        sb.append("colored=").append(colored);
        sb.append(", pages=").append(pages);
        sb.append(", glossy=").append(glossy);
        if(subscribeIndex != 0){
            sb.append(", subscribeIndex=").append(subscribeIndex);
        }
        sb.append('}');
        return sb.toString();
    }
}