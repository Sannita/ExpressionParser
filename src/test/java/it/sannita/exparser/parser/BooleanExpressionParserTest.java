package it.sannita.exparser.parser;

import it.sannita.exparser.context.BooleanContext;
import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.model.booleans.BooleanExpression;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanExpressionParserTest {

    @Test
    public void parse() throws Exception {
        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        BooleanContext booleanContext = new BooleanContext();

        BooleanExpressionParser booleanExpressionParser = new BooleanExpressionParser(table);

        String expr = "x := a and not b or not a and b => z";

        BooleanExpression be = booleanExpressionParser.parse(expr);
        assertNotNull(be);

        booleanContext.assign("a", Boolean.FALSE);
        booleanContext.assign("b", Boolean.FALSE);
        assertFalse(be.evaluate(booleanContext));
        assertFalse(booleanContext.lookup("x"));
        assertFalse(booleanContext.lookup("z"));

        booleanContext.assign("a", Boolean.FALSE);
        booleanContext.assign("b", Boolean.TRUE);
        assertTrue(be.evaluate(booleanContext));
        assertTrue(booleanContext.lookup("x"));
        assertTrue(booleanContext.lookup("z"));

        booleanContext.assign("a", Boolean.TRUE);
        booleanContext.assign("b", Boolean.FALSE);
        assertTrue(be.evaluate(booleanContext));
        assertTrue(booleanContext.lookup("x"));
        assertTrue(booleanContext.lookup("z"));

        booleanContext.assign("a", Boolean.TRUE);
        booleanContext.assign("b", Boolean.TRUE);
        assertFalse(be.evaluate(booleanContext));
        assertFalse(booleanContext.lookup("x"));
        assertFalse(booleanContext.lookup("z"));
    }
}