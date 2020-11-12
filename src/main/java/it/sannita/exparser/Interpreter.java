/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.context.BooleanContext;
import it.sannita.exparser.model.booleans.BooleanExpression;
import it.sannita.exparser.parser.BooleanExpressionParser;

public class Interpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        SymbolsTable table = ConfigFactory.getConfigFromResource("symbols.json");
        
        BooleanExpressionParser booleanExpressionParser = new BooleanExpressionParser(table);

        String expr = " a and not b or not a and b ";

        System.out.println("Input: \"" + expr + "\"\n");

        BooleanExpression be = booleanExpressionParser.parse(expr);

        System.out.println("Boolean Expression");
        System.out.println("x = " + be);
        BooleanContext booleanContext = new BooleanContext();

        System.out.println("a\tb\tx");

        booleanContext.assign("a", Boolean.FALSE);
        booleanContext.assign("b", Boolean.FALSE);
        System.out.println("false\tfalse\t" + be.evaluate(booleanContext));

        booleanContext.assign("a", Boolean.FALSE);
        booleanContext.assign("b", Boolean.TRUE);
        System.out.println("false\ttrue\t" + be.evaluate(booleanContext));

        booleanContext.assign("a", Boolean.TRUE);
        booleanContext.assign("b", Boolean.FALSE);
        System.out.println("true\tfalse\t" + be.evaluate(booleanContext));

        booleanContext.assign("a", Boolean.TRUE);
        booleanContext.assign("b", Boolean.TRUE);
        System.out.println("true\ttrue\t" + be.evaluate(booleanContext));
    }

}
