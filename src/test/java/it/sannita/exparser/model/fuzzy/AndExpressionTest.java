package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class AndExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        FuzzyClass result = andExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0);
    }

    @Test
    public void evaluateFalseTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        FuzzyClass result = andExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0);
    }

    @Test
    public void evaluateTrueFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        FuzzyClass result = andExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0);
    }

    @Test
    public void evaluateTrueTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        FuzzyClass result = andExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(new ConstantExpression(0.3), new ConstantExpression(0.9));
        FuzzyClass result = andExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.3, result.getValue(), 0);
    }
}