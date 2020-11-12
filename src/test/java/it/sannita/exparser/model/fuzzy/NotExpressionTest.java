package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NotExpressionTest {

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression notExpression = new NotExpression(ConstantExpression.FALSE);
        assertEquals(1.0, notExpression.evaluate(fuzzyContext), 0.0);
    }

    @Test
    public void evaluateTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression notExpression = new NotExpression(ConstantExpression.TRUE);
        assertEquals(0.0, notExpression.evaluate(fuzzyContext), 0.0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression notExpression = new NotExpression(new ConstantExpression(0.7));
        assertEquals(0.3, notExpression.evaluate(fuzzyContext), 0.000000001);
    }
}