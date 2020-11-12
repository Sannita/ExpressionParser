package it.sannita.exparser.configuration;

import it.sannita.exparser.model.Symbol;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigFactoryTest {

    @Test
    public void getConfigFromResource() {
        SymbolsTable config = ConfigFactory.getConfigFromResource("symbols.json");

        assertNotNull(config);
        Symbol rightParenthesis = config.getSymbol(")");
        assertNotNull(rightParenthesis);
    }

    @Test
    public void getConfigFromFile() {
    }

    @Test
    public void getConfigFromStream() {
    }
}