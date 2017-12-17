package mum.edu.domain;

public enum Gender {
    FEMALE("M"),MALE("F");

    private final String value;

    private Gender(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
