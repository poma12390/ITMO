package lab4.enums;

public enum Places {
    EARTH("Земля"),
    ROCKET("Ракета"),
    MOON_ROAD("Лунная дорожка");
    String name;

    Places(String name) {
        this.name=name;
    }
    public String toString() {
        return this.name;
    }}

