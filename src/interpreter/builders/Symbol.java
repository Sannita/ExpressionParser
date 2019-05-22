/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.builders;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author llupacchino
 */
public class Symbol {

    public static final String NOT = "not";
    public static final String AND = "and";
    public static final String OR = "or";
    public static final String LEFT_PARENTHESIS = "(";
    public static final String RIGHT_PARENTHESIS = ")";
    public static final String NULL = null;

    private final String name;
    private final int priority;
    private final Associativity associativity;
    private final Type type;

    private static final Map<String, Symbol> OPERATORS;

    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put(NOT, new Symbol(NOT, 3, Associativity.RIGHT, Type.OPERATOR));
        OPERATORS.put(AND, new Symbol(AND, 2, Associativity.LEFT, Type.OPERATOR));
        OPERATORS.put(OR, new Symbol(OR, 1, Associativity.LEFT, Type.OPERATOR));
        OPERATORS.put(LEFT_PARENTHESIS, new Symbol(LEFT_PARENTHESIS, 0, Associativity.LEFT, Type.LEFT_PARENTHESIS));
        OPERATORS.put(RIGHT_PARENTHESIS, new Symbol(RIGHT_PARENTHESIS, 10, Associativity.LEFT, Type.RIGHT_PARENTHESIS));
    }

    private Symbol(String name, int priority, Associativity associativy, Type type) {
        this.name = name;
        this.priority = priority;
        this.associativity = associativy;
        this.type = type;
    }

    public static Symbol parse(String value) {
        Symbol s = OPERATORS.get(value);
        if (s == null) {
            s = new Symbol(value, 0, Associativity.NONE, Type.OPERAND);
        }
        return s;
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /*
    @Override
    public String toString() {
        return "Operator{" + "name=" + name + ", priority=" + priority + ", associativity=" + associativity + '}';
    }
     */
    public enum Associativity {
        LEFT, RIGHT, NONE;
    }

    public enum Type {
        OPERATOR, OPERAND, RIGHT_PARENTHESIS, LEFT_PARENTHESIS;
    }
}
