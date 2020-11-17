/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class AssignmentExpression implements FuzzyExpression {

    private final VariableExpression op1;
    private final FuzzyExpression op2;

    public AssignmentExpression(VariableExpression op1, FuzzyExpression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public FuzzyClass evaluate(FuzzyContext fuzzyContext) {
        FuzzyClass result = op2.evaluate(fuzzyContext);
        fuzzyContext.assign(op1, result.getValue());
        return new FuzzyClass(op1.getVariableName(), result.getValue());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(op1).append(" = ").append(op2).append(")");
        return sb.toString();
    }

}
