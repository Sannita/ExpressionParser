package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignmentExpressionTest {

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.FALSE);
        FuzzyClass result = assignmentExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("x", result.getName());
        assertEquals(0.0, result.getValue(), 0);
        assertEquals(0.0, fuzzyContext.lookup("x"), 0);
    }

    @Test
    public void evaluateTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.TRUE);
        FuzzyClass result = assignmentExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("x", result.getName());
        assertEquals(1.0, result.getValue(), 0);
        assertEquals(1.0, fuzzyContext.lookup("x"), 0);
    }


    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), new ConstantExpression(0.3));
        FuzzyClass result = assignmentExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("x", result.getName());
        assertEquals(0.3, result.getValue(), 0);
        assertEquals(0.3, fuzzyContext.lookup("x"), 0);
    }
}