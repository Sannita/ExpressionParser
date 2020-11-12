/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser;

import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.expressions.booleans.*;
import it.sannita.exparser.model.Symbol;
import it.sannita.exparser.model.SymbolBuilder;

import java.util.*;

public final class Parser {

    private final SymbolsTable table;

    public Parser(SymbolsTable table) {
        this.table = table;
    }

    public BooleanExpression parse(String expression) throws Exception {
        List<Symbol> symbols = extractSymbols(expression);
        Deque<Symbol> stack = createStack(symbols);
        BooleanExpression result = createExpression(stack);
        return result;
    }
    
    private List<Symbol> extractSymbols(String expression) {
        List<Symbol> result = new ArrayList<>();

        Set<Integer> indexes = findSubstringIndexes(expression);
        int index = 0;
        for (int splitIndex : indexes) {
            String token = expression.substring(index, splitIndex).trim().toLowerCase();
            Symbol op = parseToken(token);
            if (op != null) {
                result.add(op);
            }
            index = splitIndex;
        }

        return result;
    }
    
    private Symbol parseToken(String value) {
        if(value == null || value.isEmpty()){
            return null;
        }
        Symbol s = table.getSymbol(value);
        if (s == null) {
            s = SymbolBuilder.getOperandBuilder(value).build();
        }
        return s;
    }

    private Set<Integer> findSubstringIndexes(String expression) {
        SortedSet<Integer> indexes = new TreeSet<>();
        for (String k : table.getSymbols()) {
            int index = 0;
            while (index != -1) {
                index = expression.indexOf(k, index);
                if (index != -1) {
                    indexes.add(index);
                    index = index + k.length();
                    indexes.add(index);
                }
            }
        }
        indexes.add(expression.length());
        return indexes;
    }

    private Deque<Symbol> createStack(List<Symbol> symbols) throws Exception {
        Deque<Symbol> stack = new ArrayDeque<>();
        Deque<Symbol> output = new ArrayDeque<>();

        for (Symbol op : symbols) {

            if (op.isOperand()) {
                output.add(op);
                continue;
            }

            if (stack.isEmpty() || op.isLeftParenthesis()) {
                stack.push(op);
                continue;
            }

            if (op.isRightParenthesis()) {
                Symbol s;
                do {
                    if (stack.isEmpty()) {
                        throw new Exception("Missing parenthesis");
                    }
                    s = stack.pop();
                    if (!s.isLeftParenthesis()) {
                        output.add(s);
                    }
                } while (!s.isLeftParenthesis());
                continue;
            }

            Symbol s = stack.peek();
            while (!stack.isEmpty() && s.getPriority() >= op.getPriority()) {
                if (s.getPriority() == op.getPriority() && s.isRightAssociative()) {
                    break;
                }
                s = stack.pop();
                output.add(s);
                s = stack.peek();
            }
            stack.push(op);
        }

        while (!stack.isEmpty()) {
            Symbol s = stack.pop();
            if (s.isLeftParenthesis() || s.isRightParenthesis()) {
                throw new Exception("Missing parenthesis");
            }
            output.add(s);
        }

        return output;
    }

    private BooleanExpression createExpression(Deque<Symbol> stack) {
        Deque<BooleanExpression> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            Symbol s = stack.pop();
            String value = s.getSymbol();

            if ("true".equals(value)) {
                BooleanExpression be = ConstantExpression.TRUE;
                temp.push(be);
                continue;
            }
            if ("false".equals(value)) {
                BooleanExpression be = ConstantExpression.FALSE;
                temp.push(be);
                continue;
            }
            if (s.isOperand()) {
                BooleanExpression be = new VariableExpression(value);
                temp.push(be);
                continue;
            }
            if ("and".equals(value)) {
                BooleanExpression op2 = temp.pop();
                BooleanExpression op1 = temp.pop();
                BooleanExpression be = new AndExpression(op1, op2);
                temp.push(be);
                continue;
            }
            if ("or".equals(value)) {
                BooleanExpression op2 = temp.pop();
                BooleanExpression op1 = temp.pop();
                BooleanExpression be =  new OrExpression(op1, op2);
                temp.push(be);
                continue;
            }
            if ("not".equals(value)) {
                BooleanExpression op = temp.pop();
                BooleanExpression be = new NotExpression(op);
                temp.push(be);
            }
        }
        return temp.pop();
    }

}
