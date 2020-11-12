package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class AndExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertEquals(0.0, andExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateFalseTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertEquals(0.0, andExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateTrueFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertEquals(0.0, andExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateTrueTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertEquals(1.0, andExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression andExpression = new AndExpression(new ConstantExpression(0.3), new ConstantExpression(0.9));
        assertEquals(0.3, andExpression.evaluate(fuzzyContext), 0);
    }
}