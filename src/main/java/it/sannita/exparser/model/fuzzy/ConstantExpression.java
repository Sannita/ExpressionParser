/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.BooleanContext;
import it.sannita.exparser.context.FuzzyContext;

import java.util.Objects;

public final class ConstantExpression implements FuzzyExpression {

    public static final FuzzyExpression TRUE = new ConstantExpression(1.0);
    public static final FuzzyExpression FALSE = new ConstantExpression(0.0);

    private final double value;

    public ConstantExpression(double value) {
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
    public Double evaluate(FuzzyContext fuzzyContext) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
