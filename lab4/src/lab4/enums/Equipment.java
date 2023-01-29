package lab4.enums;

public enum Equipment {
    EQ_FOR_MOUNTAINS("набор скалолаза "),
    USLESS_THING("бесполезная вещь");

    private String name;

    Equipment(String name) {
        this.name=name;
    }
    public String toString() {
        return this.name;
}}
