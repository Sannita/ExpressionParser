package it.sannita.exparser.parser;

import it.sannita.exparser.Context;
import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.parser.BooleanExpressionParser;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooleanExpressionParserTest {

    @Test
    public void parse() throws Exception {
        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        Context context = new Context();

        BooleanExpressionParser booleanExpressionParser = new BooleanExpressionParser(table);

        String expr = " a and not b or not a and b ";

        BooleanExpression be = booleanExpressionParser.parse(expr);
        assertNotNull(be);

        context.assign("a", Boolean.FALSE);
        context.assign("b", Boolean.FALSE);
        assertFalse(be.evaluate(context));

        context.assign("a", Boolean.FALSE);
        context.assign("b", Boolean.TRUE);
        assertTrue(be.evaluate(context));

        context.assign("a", Boolean.TRUE);
        context.assign("b", Boolean.FALSE);
        assertTrue(be.evaluate(context));

        context.assign("a", Boolean.TRUE);
        context.assign("b", Boolean.TRUE);
        assertFalse(be.evaluate(context));
    }
}