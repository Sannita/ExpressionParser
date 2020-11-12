package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantExpressionTest {

    @Test
    public void evaluateTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression constantTrue = new ConstantExpression(true);
        assertEquals(ConstantExpression.TRUE, constantTrue);
        assertTrue(constantTrue.evaluate(booleanContext));
    }

    @Test
    public void evaluateFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression constantFalse = new ConstantExpression(false);
        assertEquals(ConstantExpression.FALSE, constantFalse);
        assertFalse(constantFalse.evaluate(booleanContext));
    }
}