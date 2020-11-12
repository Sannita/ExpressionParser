package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrExpressionTest {

    @Test
    public void evaluateFalseFalse() {
        Context context = new Context();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.FALSE);
        assertFalse(orExpression.evaluate(context));
    }

    @Test
    public void evaluateFalseTrue() {
        Context context = new Context();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.FALSE, ConstantExpression.TRUE);
        assertTrue(orExpression.evaluate(context));
    }

    @Test
    public void evaluateTrueFalse() {
        Context context = new Context();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.FALSE);
        assertTrue(orExpression.evaluate(context));
    }

    @Test
    public void evaluateTrueTrue() {
        Context context = new Context();

        BooleanExpression orExpression = new OrExpression(ConstantExpression.TRUE, ConstantExpression.TRUE);
        assertTrue(orExpression.evaluate(context));
    }
}