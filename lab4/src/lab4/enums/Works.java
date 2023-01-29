package lab4.enums;

public enum Works {
    ENGINEER("Инженер"),
    BUM("безработный");

    String name;

    Works(String name) {
        this.name=name;
    }
    public String toString() {
        return this.name;
    }}

