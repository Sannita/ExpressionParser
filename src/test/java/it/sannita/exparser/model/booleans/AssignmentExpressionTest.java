package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignmentExpressionTest {

    @Test
    public void evaluateFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.FALSE);
        assertFalse(assignmentExpression.evaluate(booleanContext));
        assertFalse(booleanContext.lookup("x"));
    }

    @Test
    public void evaluateTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.TRUE);
        assertTrue(assignmentExpression.evaluate(booleanContext));
        assertTrue(booleanContext.lookup("x"));
    }

}