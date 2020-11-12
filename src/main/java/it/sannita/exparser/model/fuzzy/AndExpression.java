/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class AndExpression implements FuzzyExpression {

    private final FuzzyExpression op1;
    private final FuzzyExpression op2;

    public AndExpression(FuzzyExpression op1, FuzzyExpression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Double evaluate(FuzzyContext fuzzyContext) {
        return Math.min(op1.evaluate(fuzzyContext), op2.evaluate(fuzzyContext));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(op1).append(" AND ").append(op2).append(")");
        return sb.toString();
    }

}
