/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;

public final class VariableExpression implements BooleanExpression {

    private final String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public Boolean evaluate(BooleanContext booleanContext) {
        return booleanContext.lookup(getVariableName());
    }

    @Override
    public String toString() {
        return variableName;
    }

}
