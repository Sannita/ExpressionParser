package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class VariableExpression implements FuzzyExpression {

    private final String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public FuzzyClass evaluate(FuzzyContext fuzzyContext) {
        Double value = fuzzyContext.lookup(getVariableName());
        return new FuzzyClass(variableName, value);
    }

    @Override
    public String toString() {
        return variableName;
    }

}
