package com.nyha.task2xml.entity;

public class SciencePaper extends Paper{
    private String attestationOrganization;

    public String getAttestationOrganization() {
        return attestationOrganization;
    }

    public void setAttestationOrganization(String attestationOrganization) {
        this.attestationOrganization = attestationOrganization;
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
        SciencePaper other = (SciencePaper) obj;
        if (attestationOrganization == null) {
            if (other.attestationOrganization != null) {
                return false;
            }
        } else if (!attestationOrganization.equals(other.attestationOrganization)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((attestationOrganization != null) ? attestationOrganization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SciencePaper{");
        sb.append(super.toString());
        sb.append(", attestationOrganization=").append(attestationOrganization);
        sb.append('}');
        return sb.toString();
    }
}
