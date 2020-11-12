package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class NotExpressionTest {

    @Test
    public void evaluateFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression notExpression = new NotExpression(ConstantExpression.FALSE);
        assertTrue(notExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression notExpression = new NotExpression(ConstantExpression.TRUE);
        assertFalse(notExpression.evaluate(booleanContext));
    }
}