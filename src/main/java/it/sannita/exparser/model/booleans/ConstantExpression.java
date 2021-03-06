/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;

import java.util.Objects;

public final class ConstantExpression implements BooleanExpression {

    public static final ConstantExpression TRUE = new ConstantExpression(true);
    public static final ConstantExpression FALSE = new ConstantExpression(false);

    private final boolean value;

    public ConstantExpression(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstantExpression that = (ConstantExpression) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Boolean evaluate(BooleanContext booleanContext) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
