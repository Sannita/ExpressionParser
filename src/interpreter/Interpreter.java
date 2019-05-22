/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

/**
 *
 * @author llupacchino
 */
public class Interpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VariableExpression p = new VariableExpression("p");
        VariableExpression q = new VariableExpression("q");

        BooleanExpression e = new OrExpression(new AndExpression(new Constant(true), p), new AndExpression(q, new NotExpression(new AndExpression(q, new NotExpression(p)))));

        Context context = new Context();

        System.out.println(e);

        context.assign(p, true);
        context.assign(q, true);
        System.out.println("(p=true,q=true) The result is: " + e.evaluate(context));

        context.assign(p, true);
        context.assign(q, false);
        System.out.println("(p=true,q=false) The result is: " + e.evaluate(context));

        context.assign(p, false);
        context.assign(q, true);
        System.out.println("(p=false,q=true) The result is: " + e.evaluate(context));

        context.assign(p, false);
        context.assign(q, false);
        System.out.println("(p=false,q=false) The result is: " + e.evaluate(context));
    }

}
