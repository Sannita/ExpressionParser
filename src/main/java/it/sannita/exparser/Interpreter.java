/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.expressions.booleans.BooleanExpression;

public class Interpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        
        Parser parser = new Parser(table);

        String expr = " a and not b or not a and b ";

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
