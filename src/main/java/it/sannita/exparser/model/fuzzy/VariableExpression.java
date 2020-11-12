/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public Double evaluate(FuzzyContext fuzzyContext) {
        return fuzzyContext.lookup(getVariableName());
    }

    @Override
    public String toString() {
        return variableName;
    }

}
