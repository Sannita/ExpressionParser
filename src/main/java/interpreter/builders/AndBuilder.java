/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.builders;

import interpreter.AndExpression;
import interpreter.BooleanExpression;

public class AndBuilder implements ExpressionBuilder{

    private BooleanExpression op1;
    private BooleanExpression op2;
    
    public AndBuilder(){
        
    }
    
    public AndBuilder withValues(BooleanExpression op1, BooleanExpression op2){
        this.op1 = op1;
        this.op2 = op2;
        return this;
    }

    @Override
    public BooleanExpression build() {
        return new AndExpression(op1, op2);
    }
    
}
