/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class NotExpression implements FuzzyExpression {

    private final FuzzyExpression op;

    public NotExpression(FuzzyExpression op) {
        this.op = op;
    }

    @Override
    public Double evaluate(FuzzyContext fuzzyContext) {
        return 1.0 - op.evaluate(fuzzyContext);
    }

    @Override
    public String toString() {
        return "NOT " + op;
    }
}
