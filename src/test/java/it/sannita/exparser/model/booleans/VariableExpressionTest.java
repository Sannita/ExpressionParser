package it.sannita.exparser.model.booleans;

import it.sannita.exparser.Context;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.model.booleans.VariableExpression;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableExpressionTest {

    @Test
    public void getVariableName() {
    }

    @Test
    public void evaluateTrue() {
        Context context = new Context();
        context.assign("VAR_1", true);

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertTrue(variableExpression.evaluate(context));
    }

    @Test
    public void evaluateFalse() {
        Context context = new Context();
        context.assign("VAR_1", false);

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertFalse(variableExpression.evaluate(context));
    }

    @Test
    public void evaluateEmpty() {
        Context context = new Context();

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertNull(variableExpression.evaluate(context));
    }

    @Test
    public void evaluate() {
        Context context = new Context();
        VariableExpression variableExpression = new VariableExpression("VAR_1");
        context.assign(variableExpression, true);

        assertTrue(variableExpression.evaluate(context));
    }
}