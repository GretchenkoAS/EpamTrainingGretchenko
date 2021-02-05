package com.nyha.task2xml.entity;

public class ArtPaper extends Paper{
    private Assigment assigment;

    public Assigment getAssigment() {
        return assigment;
    }

    public void setAssigment(Assigment assigment) {
        this.assigment = assigment;
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
        if (!super.equals(obj)) {
            return false;
        }
        ArtPaper other = (ArtPaper) obj;
        if (assigment == null) {
            if (other.assigment != null) {
                return false;
            }
        } else if (!assigment.equals(other.assigment)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((assigment != null) ? assigment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArtPaper{");
        sb.append(super.toString());
        sb.append(", assigment=").append(assigment);
        sb.append('}');
        return sb.toString();
    }
}
