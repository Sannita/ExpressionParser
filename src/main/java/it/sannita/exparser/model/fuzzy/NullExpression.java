/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;

public final class NullExpression implements FuzzyExpression {

    public NullExpression() {
    }

    @Override
    public Double evaluate(FuzzyContext fuzzyContext) {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

}
