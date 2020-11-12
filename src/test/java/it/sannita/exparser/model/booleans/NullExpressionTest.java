package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class NullExpressionTest {

    @Test
    public void evaluateFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression nullExpression = new NullExpression();
        assertNull(nullExpression.evaluate(booleanContext));
    }

}