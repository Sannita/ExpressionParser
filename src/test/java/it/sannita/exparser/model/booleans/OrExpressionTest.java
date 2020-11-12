package it.sannita.exparser.model.booleans;

import it.sannita.exparser.context.BooleanContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertFalse(orExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateFalseTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertTrue(orExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateTrueFalse() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertTrue(orExpression.evaluate(booleanContext));
    }

    @Test
    public void evaluateTrueTrue() {
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertTrue(orExpression.evaluate(booleanContext));
    }
}