package it.sannita.exparser.model;

public final class SymbolBuilder {
    private final String symbol;
    private final int priority;
    private final Symbol.Associativity associativity;
    private final Symbol.Type type;

    private SymbolBuilder(String symbol, int priority, Symbol.Associativity associativity, Symbol.Type type) {
        this.symbol = symbol;
        this.priority = priority;
        this.associativity = associativity;
        this.type = type;
    }

    public static SymbolBuilder getSymbolBuilder(String symbol, int priority, String associativity, String type){
        return new SymbolBuilder(symbol, priority, Symbol.Associativity.valueOf(associativity), Symbol.Type.valueOf(type));
    }

    public static SymbolBuilder getOperandBuilder(String name){
        return new SymbolBuilder(name, 0, Symbol.Associativity.NONE, Symbol.Type.OPERAND);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public Symbol.Associativity getAssociativity() {
        return associativity;
    }

    public Symbol.Type getType() {
        return type;
    }

    public Symbol build(){
        return new Symbol(this);
    }
}
