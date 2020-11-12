/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;

public final class NotExpression implements BooleanExpression {

    private final BooleanExpression op;

    public NotExpression(BooleanExpression op) {
        this.op = op;
    }

    @Override
    public Boolean evaluate(BooleanContext booleanContext) {
        return !op.evaluate(booleanContext);
    }

    @Override
    public String toString() {
        return "NOT " + op;
    }
}
