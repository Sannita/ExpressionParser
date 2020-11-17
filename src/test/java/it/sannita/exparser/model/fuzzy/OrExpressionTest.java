package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        FuzzyClass result = orExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.0, result.getValue(), 0);
    }

    @Test
    public void evaluateFalseTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        FuzzyClass result = orExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0);
    }

    @Test
    public void evaluateTrueFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        FuzzyClass result = orExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0);
    }

    @Test
    public void evaluateTrueTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        FuzzyClass result = orExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(1.0, result.getValue(), 0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(new ConstantExpression(0.3), new ConstantExpression(0.9));
        FuzzyClass result = orExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertNull(result.getName());
        assertEquals(0.9, result.getValue(), 0);
    }

}