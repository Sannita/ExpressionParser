/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.model;

public final class Symbol {

    public enum Associativity {
        LEFT, RIGHT, NONE;
    }

    public enum Type {
        OPERATOR, OPERAND, RIGHT_PARENTHESIS, LEFT_PARENTHESIS, NONE;
    }

    private final String symbol;
    private final int priority;
    private final Associativity associativity;
    private final Type type;

    Symbol(SymbolBuilder builder) {
        this.symbol = builder.getSymbol();
        this.priority = builder.getPriority();
        this.associativity = builder.getAssociativity();
        this.type = builder.getType();
    }

    public boolean isOperator() {
        return type == Type.OPERATOR;
    }

    public boolean isOperand() {
        return type == Type.OPERAND;
    }

    public boolean isLeftParenthesis() {
        return type == Type.LEFT_PARENTHESIS;
    }

    public boolean isRightParenthesis() {
        return type == Type.RIGHT_PARENTHESIS;
    }

    public boolean isLeftAssociative() {
        return associativity == Associativity.LEFT;
    }

    public boolean isRightAssociative() {
        return associativity == Associativity.RIGHT;
    }

    public int getPriority() {
        return priority;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
