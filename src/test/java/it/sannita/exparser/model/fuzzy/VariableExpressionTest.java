package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableExpressionTest {

    @Test
    public void getVariableName() {
    }

    @Test
    public void evaluateEmpty() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression variableExpression = new VariableExpression("VAR_1");
        assertNull(variableExpression.evaluate(fuzzyContext));
    }

    @Test
    public void evaluateValue() {
        FuzzyContext fuzzyContext = new FuzzyContext();
        fuzzyContext.assign("VAR_1", 0.3);

        FuzzyExpression variableExpression = new VariableExpression("VAR_1");
        assertEquals(0.3, variableExpression.evaluate(fuzzyContext), 0);
    }

    @Test
    public void evaluateVariable() {
        FuzzyContext fuzzyContext = new FuzzyContext();
        VariableExpression variableExpression = new VariableExpression("VAR_1");
        fuzzyContext.assign(variableExpression, 0.3);

        assertEquals(0.3, variableExpression.evaluate(fuzzyContext), 0);
    }
}