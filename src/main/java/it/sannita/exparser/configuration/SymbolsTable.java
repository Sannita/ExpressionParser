package it.sannita.exparser.configuration;

import it.sannita.exparser.model.Symbol;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class SymbolsTable {
    private final Map<String, Symbol> symbols;

    SymbolsTable(Map<String, Symbol> symbols) {
        this.symbols = Collections.unmodifiableMap(symbols);
    }

    public Symbol getSymbol(String symbol){
        return symbols.get(symbol);
    }

    public Set<String> getSymbols(){
        return symbols.keySet();
    }
}
