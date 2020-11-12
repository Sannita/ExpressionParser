/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import interpreter.builders.Symbol;
import java.util.Map;

public class Interpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Map<String, Symbol> table = Symbol.configSymbols("config.csv");
        
        Parser parser = new Parser(table);

        String expr = " a and not b or not a and b";

        System.out.println("Input: \"" + expr + "\"\n");

        BooleanExpression be = parser.parse(expr);

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
