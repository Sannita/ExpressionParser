/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

public class Constant implements BooleanExpression {

    private final boolean value;

    public Constant(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean evaluate(Context context) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
