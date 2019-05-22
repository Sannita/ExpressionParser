/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

public class NullExpression implements BooleanExpression {

    public NullExpression() {
    }

    @Override
    public Boolean evaluate(Context context) {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

}
