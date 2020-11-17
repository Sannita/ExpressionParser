/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import it.sannita.exparser.context.FuzzyContext;
import it.sannita.exparser.model.fuzzy.FuzzyExpression;

public final class AssignmentExpression implements BooleanExpression {

    private final VariableExpression op1;
    private final BooleanExpression op2;

    public AssignmentExpression(VariableExpression op1, BooleanExpression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Boolean evaluate(BooleanContext booleanContext) {
        Boolean result = op2.evaluate(booleanContext);
        booleanContext.assign(op1, result);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(op1).append(" = ").append(op2).append(")");
        return sb.toString();
    }

}
