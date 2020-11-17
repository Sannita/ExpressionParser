package it.sannita.exparser.model.fuzzy;

public class FuzzyClass {
    private final String name;
    private final Double value;

    public FuzzyClass(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
