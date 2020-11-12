/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser;

public class VariableExpression implements BooleanExpression {

    private final String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public Boolean evaluate(Context context) {
        return context.lookup(getVariableName());
    }

    @Override
    public String toString() {
        return variableName;
    }

}
