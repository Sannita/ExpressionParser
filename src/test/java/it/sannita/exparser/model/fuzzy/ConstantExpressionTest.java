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
        FuzzyClass result = constantTrue.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0.0);
    }

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression constantTrue = new ConstantExpression(0.0);
        assertEquals(ConstantExpression.FALSE, constantTrue);
        FuzzyClass result = constantTrue.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0.0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression constantTrue = new ConstantExpression(0.6);
        FuzzyClass result = constantTrue.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.6, result.getValue(), 0.0);
    }

}