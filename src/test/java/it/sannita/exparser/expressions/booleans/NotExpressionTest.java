package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class NotExpressionTest {

    @Test
    public void evaluateFalse() {
        Context context = new Context();

        BooleanExpression notExpression = new NotExpression(ConstantExpression.FALSE);
        assertTrue(notExpression.evaluate(context));
    }

    @Test
    public void evaluateTrue() {
        Context context = new Context();

        BooleanExpression notExpression = new NotExpression(ConstantExpression.TRUE);
        assertFalse(notExpression.evaluate(context));
    }
}