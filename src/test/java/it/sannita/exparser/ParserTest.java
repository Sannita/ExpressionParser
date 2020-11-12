package it.sannita.exparser;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.expressions.booleans.BooleanExpression;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parse() throws Exception {
        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        Context context = new Context();

        Parser parser = new Parser(table);

        String expr = " a and not b or not a and b ";

        BooleanExpression be = parser.parse(expr);
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