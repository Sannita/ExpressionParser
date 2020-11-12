/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

public class NotExpression implements BooleanExpression {

    private final BooleanExpression op;

    public NotExpression(BooleanExpression op) {
        this.op = op;
    }

    @Override
    public Boolean evaluate(Context context) {
        return !op.evaluate(context);
    }

    @Override
    public String toString() {
        return "NOT " + op;
    }
}
