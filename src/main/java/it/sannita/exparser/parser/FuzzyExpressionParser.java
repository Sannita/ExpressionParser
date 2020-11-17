/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.parser;

import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.model.Symbol;
import it.sannita.exparser.model.SymbolBuilder;
import it.sannita.exparser.model.fuzzy.*;

import java.util.*;

public final class FuzzyExpressionParser {

    private final SymbolsTable table;

    public FuzzyExpressionParser(SymbolsTable table) {
        this.table = table;
    }

    public FuzzyExpression parse(String expression) throws Exception {
        List<Symbol> symbols = extractSymbols(expression);
        Deque<Symbol> stack = createStack(symbols);
        FuzzyExpression result = createExpression(stack);
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

    private FuzzyExpression createExpression(Deque<Symbol> stack) {
        Deque<FuzzyExpression> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            Symbol s = stack.pop();
            String value = s.getSymbol();

            if ("true".equals(value)) {
                FuzzyExpression fe = ConstantExpression.TRUE;
                temp.push(fe);
                continue;
            }
            if ("false".equals(value)) {
                FuzzyExpression fe = ConstantExpression.FALSE;
                temp.push(fe);
                continue;
            }
            if (s.isOperand()) {
                FuzzyExpression fe;
                try{
                    double doubleValue = Double.parseDouble(value);
                    if(doubleValue < 0 || doubleValue > 1){
                        fe = new NullExpression();
                    }else{
                        fe = new ConstantExpression(doubleValue);
                    }
                }catch (NumberFormatException nfe){
                    fe = new VariableExpression(value);
                }
                temp.push(fe);
                continue;
            }
            if ("and".equals(value)) {
                FuzzyExpression op2 = temp.pop();
                FuzzyExpression op1 = temp.pop();
                FuzzyExpression fe = new AndExpression(op1, op2);
                temp.push(fe);
                continue;
            }
            if ("or".equals(value)) {
                FuzzyExpression op2 = temp.pop();
                FuzzyExpression op1 = temp.pop();
                FuzzyExpression fe =  new OrExpression(op1, op2);
                temp.push(fe);
                continue;
            }
            if ("not".equals(value)) {
                FuzzyExpression op = temp.pop();
                FuzzyExpression fe = new NotExpression(op);
                temp.push(fe);
                continue;
            }
            if ("=".equals(value)) {
                FuzzyExpression op2 = temp.pop();
                VariableExpression op1 = (VariableExpression)temp.pop();
                FuzzyExpression fe =  new AssignmentExpression(op1, op2);
                temp.push(fe);
            }
        }
        return temp.pop();
    }

}
