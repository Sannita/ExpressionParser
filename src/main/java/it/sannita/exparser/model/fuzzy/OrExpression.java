/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class OrExpression implements FuzzyExpression {

    private final FuzzyExpression op1;
    private final FuzzyExpression op2;

    public OrExpression(FuzzyExpression op1, FuzzyExpression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public FuzzyClass evaluate(FuzzyContext fuzzyContext) {
        Double v1 = op1.evaluate(fuzzyContext).getValue();
        Double v2 = op2.evaluate(fuzzyContext).getValue();
        Double result = Math.max(v1, v2);

        return new FuzzyClass(null, result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(op1).append(" OR ").append(op2).append(")");
        return sb.toString();
    }

}
