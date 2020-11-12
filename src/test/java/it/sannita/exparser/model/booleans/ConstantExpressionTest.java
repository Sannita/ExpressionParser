package it.sannita.exparser.model.booleans;

import it.sannita.exparser.Context;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.model.booleans.ConstantExpression;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantExpressionTest {

    @Test
    public void evaluateTrue() {
        Context context = new Context();

        BooleanExpression constantTrue = new ConstantExpression(true);
        assertEquals(ConstantExpression.TRUE, constantTrue);
        assertTrue(constantTrue.evaluate(context));
    }

    @Test
    public void evaluateFalse() {
        Context context = new Context();

        BooleanExpression constantFalse = new ConstantExpression(false);
        assertEquals(ConstantExpression.FALSE, constantFalse);
        assertFalse(constantFalse.evaluate(context));
    }
}