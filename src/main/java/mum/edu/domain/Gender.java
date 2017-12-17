package mum.edu.domain;

public enum Gender {
    FEMALE("F"),MALE("M");

    private final String value;

    private Gender(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
