package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;
import org.junit.Test;

import static org.junit.Assert.*;

public class AndExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        Context context = new Context();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertFalse(andExpression.evaluate(context));
    }

    @Test
    public void evaluateFalseTrue() {
        Context context = new Context();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertFalse(andExpression.evaluate(context));
    }

    @Test
    public void evaluateTrueFalse() {
        Context context = new Context();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertFalse(andExpression.evaluate(context));
    }

    @Test
    public void evaluateTrueTrue() {
        Context context = new Context();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertTrue(andExpression.evaluate(context));
    }
}