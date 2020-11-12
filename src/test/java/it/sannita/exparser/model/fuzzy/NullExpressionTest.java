package it.sannita.exparser.model.fuzzy;

import it.sannita.exparser.context.FuzzyContext;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class NullExpressionTest {

    @Test
    public void evaluateFalse() {
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpression nullExpression = new NullExpression();
        assertNull(nullExpression.evaluate(fuzzyContext));
    }

}