package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssignmentExpressionTest {

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.FALSE);
        assertEquals(0.0, assignmentExpression.evaluate(fuzzyContext), 0);
        assertEquals(0.0, fuzzyContext.lookup("x"), 0);
    }

    @Test
    public void evaluateTrue() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), ConstantExpression.TRUE);
        assertEquals(1.0, assignmentExpression.evaluate(fuzzyContext), 0);
        assertEquals(1.0, fuzzyContext.lookup("x"), 0);
    }


    @Test
    public void evaluate() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression assignmentExpression = new AssignmentExpression(new VariableExpression("x"), new ConstantExpression(0.3));
        assertEquals(0.3, assignmentExpression.evaluate(fuzzyContext), 0);
        assertEquals(0.3, fuzzyContext.lookup("x"), 0);
    }
}