package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableExpressionTest {

    @Test
    public void getVariableName() {
    }

    @Test
    public void evaluateTrue() {
        BooleanContext booleanContext = new BooleanContext();
        booleanContext.assign("VAR_1", true);

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertTrue(variableExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateFalse() {
        BooleanContext booleanContext = new BooleanContext();
        booleanContext.assign("VAR_1", false);

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertFalse(variableExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateEmpty() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression variableExpression = new VariableExpression("VAR_1");
        assertNull(variableExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluate() {
        BooleanContext booleanContext = new BooleanContext();
        VariableExpression variableExpression = new VariableExpression("VAR_1");
        booleanContext.assign(variableExpression, true);

        assertTrue(variableExpression.evaluate(booleanContext));
    }
}