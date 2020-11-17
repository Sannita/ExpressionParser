package it.sannita.exparser.parser;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.context.FuzzyContext;
import it.sannita.exparser.model.fuzzy.FuzzyExpression;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FuzzyExpressionParserTest {

    @Test
    public void parse() throws Exception {
        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpressionParser fuzzyExpressionParser = new FuzzyExpressionParser(table);

        String expr = "x := a and not b or not a and b => z";

        FuzzyExpression be = fuzzyExpressionParser.parse(expr);
        assertNotNull(be);

        fuzzyContext.assign("a", 0.0);
        fuzzyContext.assign("b", 0.0);
        assertEquals(0.0, be.evaluate(fuzzyContext), 0);
        assertEquals(0.0, fuzzyContext.lookup("x"), 0);
        assertEquals(0.0, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.0);
        fuzzyContext.assign("b", 1.0);
        assertEquals(1.0, be.evaluate(fuzzyContext), 0);
        assertEquals(1.0, fuzzyContext.lookup("x"), 0);
        assertEquals(1.0, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 1.0);
        fuzzyContext.assign("b", 0.0);
        assertEquals(1.0, be.evaluate(fuzzyContext), 0);
        assertEquals(1.0, fuzzyContext.lookup("x"), 0);
        assertEquals(1.0, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 1.0);
        fuzzyContext.assign("b", 1.0);
        assertEquals(0.0, be.evaluate(fuzzyContext), 0);
        assertEquals(0.0, fuzzyContext.lookup("x"), 0);
        assertEquals(0.0, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.3);
        fuzzyContext.assign("b", 0.3);
        assertEquals(0.3, be.evaluate(fuzzyContext), 0);
        assertEquals(0.3, fuzzyContext.lookup("x"), 0);
        assertEquals(0.3, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.5);
        fuzzyContext.assign("b", 0.5);
        assertEquals(0.5, be.evaluate(fuzzyContext), 0);
        assertEquals(0.5, fuzzyContext.lookup("x"), 0);
        assertEquals(0.5, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.8);
        fuzzyContext.assign("b", 0.8);
        assertEquals(0.2, be.evaluate(fuzzyContext), 0.000000001);
        assertEquals(0.2, fuzzyContext.lookup("x"), 0.000000001);
        assertEquals(0.2, fuzzyContext.lookup("z"), 0.000000001);

        fuzzyContext.assign("a", 0.3);
        fuzzyContext.assign("b", 0.8);
        assertEquals(0.7, be.evaluate(fuzzyContext), 0);
        assertEquals(0.7, fuzzyContext.lookup("x"), 0);
        assertEquals(0.7, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.8);
        fuzzyContext.assign("b", 0.3);
        assertEquals(0.7, be.evaluate(fuzzyContext), 0);
        assertEquals(0.7, fuzzyContext.lookup("x"), 0);
        assertEquals(0.7, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.2);
        fuzzyContext.assign("b", 0.3);
        assertEquals(0.3, be.evaluate(fuzzyContext), 0);
        assertEquals(0.3, fuzzyContext.lookup("x"), 0);
        assertEquals(0.3, fuzzyContext.lookup("z"), 0);

        fuzzyContext.assign("a", 0.3);
        fuzzyContext.assign("b", 0.2);
        assertEquals(0.3, be.evaluate(fuzzyContext), 0);
        assertEquals(0.3, fuzzyContext.lookup("x"), 0);
        assertEquals(0.3, fuzzyContext.lookup("z"), 0);

    }
}