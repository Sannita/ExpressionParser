/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;

public final class NullExpression implements BooleanExpression {

    public NullExpression() {
    }

    @Override
    public Boolean evaluate(BooleanContext booleanContext) {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

}
