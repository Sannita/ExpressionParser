package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantExpressionTest {

    @Test
    public void evaluateTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression constantTrue = new ConstantExpression(1.0);
        assertEquals(ConstantExpression.TRUE, constantTrue);
        assertEquals(1.0, constantTrue.evaluate(fuzzyContext), 0.0);
    }

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression constantTrue = new ConstantExpression(0.0);
        assertEquals(ConstantExpression.FALSE, constantTrue);
        assertEquals(0.0, constantTrue.evaluate(fuzzyContext), 0.0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression constantTrue = new ConstantExpression(0.6);
        assertEquals(0.6, constantTrue.evaluate(fuzzyContext), 0.0);
    }

}