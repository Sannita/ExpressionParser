package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertEquals(0.0, orExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateFalseTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertEquals(1.0, orExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateTrueFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertEquals(1.0, orExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateTrueTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertEquals(1.0, orExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression orExpression = new OrExpression(new ConstantExpression(0.3), new ConstantExpression(0.9));
        assertEquals(0.9, orExpression.evaluate(fuzzyContext), 0);
    }

}