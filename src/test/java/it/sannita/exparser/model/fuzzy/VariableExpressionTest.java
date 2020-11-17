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

        FuzzyExpression variableExpression = new VariableExpression("NS");
        FuzzyClass result = variableExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("NS", result.getName());
        assertNull(result.getValue());
    }

    @Test
    public void evaluateValue() {
        FuzzyContext fuzzyContext = new FuzzyContext();
        fuzzyContext.assign("NS", 0.3);

        FuzzyExpression variableExpression = new VariableExpression("NS");
        FuzzyClass result = variableExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("NS", result.getName());
        assertEquals(0.3, result.getValue(), 0);
    }

    @Test
    public void evaluateVariable() {
        FuzzyContext fuzzyContext = new FuzzyContext();
        VariableExpression variableExpression = new VariableExpression("NS");
        fuzzyContext.assign(variableExpression, 0.3);

        FuzzyClass result = variableExpression.evaluate(fuzzyContext);
        assertNotNull(result);
        assertEquals("NS", result.getName());
        assertEquals(0.3, result.getValue(), 0);
    }
}