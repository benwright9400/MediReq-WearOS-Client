package com.wrightapplications.medireq_client.business_layer;

public class SignUpForm {
    private String name;
    private String addressFirstLine;
    private String postCode;
    private String dateOfBirth;
    private boolean acceptedTerms;

    public SignUpForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressFirstLine() {
        return addressFirstLine;
    }

    public void setAddressFirstLine(String addressFirstLine) {
        this.addressFirstLine = addressFirstLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(boolean acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }

    public void formatAndPost() {
        System.out.println("form content: { name: '" + name + "', address: '" + addressFirstLine + "', postCode: '" + postCode + "', dateOfBirth: '" + dateOfBirth + "', acceptedTerms: " + acceptedTerms + "}" );
    }
}
