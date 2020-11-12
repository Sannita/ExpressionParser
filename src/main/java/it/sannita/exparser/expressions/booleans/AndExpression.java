/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;

public final class AndExpression implements BooleanExpression {

    private final BooleanExpression op1;
    private final BooleanExpression op2;

    public AndExpression(BooleanExpression op1, BooleanExpression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Boolean evaluate(Context context) {
        return op1.evaluate(context) && op2.evaluate(context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(op1).append(" AND ").append(op2).append(")");
        return sb.toString();
    }

}
