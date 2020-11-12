/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.builders;

import it.sannita.exparser.BooleanExpression;
import it.sannita.exparser.NotExpression;

public class NotBuilder implements ExpressionBuilder{

    private BooleanExpression op;
    
    public NotBuilder(){
        
    }
    
    public NotBuilder withOperand(BooleanExpression operand){
        this.op = operand;
        return this;
    }
    
    @Override
    public BooleanExpression build() {
        return new NotExpression(op);
    }
    
}
