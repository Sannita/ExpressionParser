package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;
import org.junit.Test;

import static org.junit.Assert.*;

public class NullExpressionTest {

    @Test
    public void evaluateFalse() {
        Context context = new Context();

        BooleanExpression nullExpression = new NullExpression();
        assertNull(nullExpression.evaluate(context));
    }

}