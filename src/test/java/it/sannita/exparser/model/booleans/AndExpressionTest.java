package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class AndExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertFalse(andExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateFalseTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertFalse(andExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateTrueFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertFalse(andExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateTrueTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression andExpression = new AndExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertTrue(andExpression.evaluate(booleanContext));
    }
}