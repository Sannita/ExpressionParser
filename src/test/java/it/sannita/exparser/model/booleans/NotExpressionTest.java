package it.sannita.exparser.model.booleans;

import it.sannita.exparser.Context;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.model.booleans.ConstantExpression;
import it.sannita.exparser.model.booleans.NotExpression;
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