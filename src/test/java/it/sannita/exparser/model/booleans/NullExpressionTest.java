package it.sannita.exparser.model.booleans;

import it.sannita.exparser.Context;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.model.booleans.NullExpression;
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