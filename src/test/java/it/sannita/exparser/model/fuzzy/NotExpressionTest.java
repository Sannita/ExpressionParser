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
        FuzzyClass result = notExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0);
    }

    @Test
    public void evaluateTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression notExpression = new NotExpression(ConstantExpression.TRUE);
        FuzzyClass result = notExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression notExpression = new NotExpression(new ConstantExpression(0.7));
        FuzzyClass result = notExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.3, result.getValue(), 0.00000001);
    }
}