package it.sannita.exparser.parser;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.context.FuzzyContext;
import it.sannita.exparser.model.fuzzy.FuzzyClass;
import it.sannita.exparser.model.fuzzy.FuzzyExpression;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuzzyExpressionParserTest {

    @Test
    public void parse() throws Exception {
        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        FuzzyContext fuzzyContext = new FuzzyContext();

        FuzzyExpressionParser fuzzyExpressionParser = new FuzzyExpressionParser(table);

        String expr = "ZE and PS => NS";

        FuzzyExpression fuzzyExpression = fuzzyExpressionParser.parse(expr);
        assertNotNull(fuzzyExpression);

        fuzzyContext.assign("ZE", 0.0);
        fuzzyContext.assign("PS", 0.0);
        assertEquals(0.0, fuzzyContext.lookup("ZE"), 0);
        assertEquals(0.0, fuzzyContext.lookup("PS"), 0);
        assertNull(fuzzyContext.lookup("NS"));
        FuzzyClass result1 = fuzzyExpression.evaluate(fuzzyContext);
        assertNotNull(result1);
        assertEquals("NS", result1.getName());
        assertEquals(0.0, result1.getValue(), 0);
        assertEquals(0.0, fuzzyContext.lookup("NS"), 0);

        fuzzyContext.clear();
        fuzzyContext.assign("ZE", 0.0);
        fuzzyContext.assign("PS", 1.0);
        assertEquals(0.0, fuzzyContext.lookup("ZE"), 0);
        assertEquals(1.0, fuzzyContext.lookup("PS"), 0);
        assertNull(fuzzyContext.lookup("NS"));
        FuzzyClass result2 = fuzzyExpression.evaluate(fuzzyContext);
        assertNotNull(result2);
        assertEquals("NS", result2.getName());
        assertEquals(0.0, result2.getValue(), 0);
        assertEquals(0.0, fuzzyContext.lookup("NS"), 0);

        fuzzyContext.clear();
        fuzzyContext.assign("ZE", 1.0);
        fuzzyContext.assign("PS", 0.0);
        assertEquals(1.0, fuzzyContext.lookup("ZE"), 0);
        assertEquals(0.0, fuzzyContext.lookup("PS"), 0);
        assertNull(fuzzyContext.lookup("NS"));
        FuzzyClass result3 = fuzzyExpression.evaluate(fuzzyContext);
        assertNotNull(result3);
        assertEquals("NS", result3.getName());
        assertEquals(0.0, result3.getValue(), 0);
        assertEquals(0.0, fuzzyContext.lookup("NS"), 0);

        fuzzyContext.clear();
        fuzzyContext.assign("ZE", 1.0);
        fuzzyContext.assign("PS", 1.0);
        assertEquals(1.0, fuzzyContext.lookup("ZE"), 0);
        assertEquals(1.0, fuzzyContext.lookup("PS"), 0);
        assertNull(fuzzyContext.lookup("NS"));
        FuzzyClass result4 = fuzzyExpression.evaluate(fuzzyContext);
        assertNotNull(result4);
        assertEquals("NS", result4.getName());
        assertEquals(1.0, result4.getValue(), 0);
        assertEquals(1.0, fuzzyContext.lookup("NS"), 0);

        fuzzyContext.clear();
        fuzzyContext.assign("ZE", 0.3);
        fuzzyContext.assign("PS", 0.8);
        assertEquals(0.3, fuzzyContext.lookup("ZE"), 0);
        assertEquals(0.8, fuzzyContext.lookup("PS"), 0);
        assertNull(fuzzyContext.lookup("NS"));
        FuzzyClass result5 = fuzzyExpression.evaluate(fuzzyContext);
        assertNotNull(result5);
        assertEquals("NS", result5.getName());
        assertEquals(0.3, result5.getValue(), 0);
        assertEquals(0.3, fuzzyContext.lookup("NS"), 0);

    }
}