/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.builders.AndBuilder;
import interpreter.builders.ConstantBuilder;
import interpreter.builders.NotBuilder;
import interpreter.builders.OrBuilder;
import interpreter.builders.Symbol;
import interpreter.builders.VariableBuilder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author llupacchino
 */
public class Parser {

    public static List<Symbol> expressionToSymbols(String expression) {

        List<Symbol> symbols = new ArrayList<>();
        while (expression.length() > 0) {
            int spaceInd = expression.indexOf(" ");
            if (spaceInd == -1) {
                spaceInd = Integer.MAX_VALUE;
            }
            int leftParInd = expression.indexOf("(");
            if (leftParInd == -1) {
                leftParInd = Integer.MAX_VALUE;
            }
            int rightParInd = expression.indexOf(")");
            if (rightParInd == -1) {
                rightParInd = Integer.MAX_VALUE;
            }

            int minIndex = Math.min(Math.min(spaceInd, leftParInd), rightParInd);
            if (minIndex == 0 || minIndex == Integer.MAX_VALUE) {
                minIndex = 1;
            }

            String toParse = expression.substring(0, minIndex).trim().toLowerCase();
            expression = expression.substring(minIndex);

            if (toParse != null && !toParse.isEmpty()) {
                Symbol op = Symbol.parse(toParse);
                symbols.add(op);
            }

        }
        return symbols;
    }

    public static Deque<Symbol> symbolsToStack(List<Symbol> symbols) throws Exception {
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
                do{
                    if(stack.isEmpty()){
                        throw new Exception("Missing parenthesis");
                    }
                    s = stack.pop();
                    if(!s.isLeftParenthesis()){
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
            if(s.isLeftParenthesis()|| s.isRightParenthesis()){
                 throw new Exception("Missing parenthesis");
            }
            output.add(s);
        }

        return output;
    }

    public static BooleanExpression stackToBooleanExpression(Deque<Symbol> stack) {
        Deque<BooleanExpression> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            Symbol s = stack.pop();
            String value = s.getName();
            
            if ("true".equals(value)) {
                BooleanExpression be = new ConstantBuilder().withValue(value).build();
                temp.push(be);
                continue;
            }
            if ("false".equals(value)) {
                BooleanExpression be = new ConstantBuilder().withValue(value).build();
                temp.push(be);
                continue;
            }
            if (s.isOperand()) {
                BooleanExpression be = new VariableBuilder().withName(value).build();
                temp.push(be);
                continue;
            }
            if ("and".equals(value)) {
                BooleanExpression op2 = temp.pop();
                BooleanExpression op1 = temp.pop();
                BooleanExpression be = new AndBuilder().withValues(op1, op2).build();
                temp.push(be);
                continue;
            }
            if ("or".equals(value)) {
                BooleanExpression op2 = temp.pop();
                BooleanExpression op1 = temp.pop();
                BooleanExpression be = new OrBuilder().withValues(op1, op2).build();
                temp.push(be);
                continue;
            }
            if ("not".equals(value)) {
                BooleanExpression op = temp.pop();
                BooleanExpression be = new NotBuilder().withOperand(op).build();
                temp.push(be);
            }
        }
        return temp.pop();
    }

    public static void main(String... args) throws Exception {
        String expr = " a and not (b or not a and b)";

        System.out.println("Input: \"" + expr + "\"\n");
        List<Symbol> temp = expressionToSymbols(expr);
        Deque<Symbol> output = symbolsToStack(temp);
        BooleanExpression be = stackToBooleanExpression(output);
        System.out.println("Boolean Expression");
        System.out.println("x = " + be);
        Context context = new Context();
        
        System.out.println("a\tb\tx");
        
        context.assign("a", Boolean.FALSE);
        context.assign("b", Boolean.FALSE);
        System.out.println("false\tfalse\t" + be.evaluate(context));
        
        context.assign("a", Boolean.FALSE);
        context.assign("b", Boolean.TRUE);
        System.out.println("false\ttrue\t" + be.evaluate(context));
        
        context.assign("a", Boolean.TRUE);
        context.assign("b", Boolean.FALSE);
        System.out.println("true\tfalse\t" + be.evaluate(context));
        
        context.assign("a", Boolean.TRUE);
        context.assign("b", Boolean.TRUE);
        System.out.println("true\ttrue\t" + be.evaluate(context));
    }
}
