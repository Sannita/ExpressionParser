/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.builders;

import it.sannita.exparser.BooleanExpression;
import it.sannita.exparser.OrExpression;

public class OrBuilder implements ExpressionBuilder{

    private BooleanExpression op1;
    private BooleanExpression op2;
    
    public OrBuilder(){
        
    }
    
     public OrBuilder withValues(BooleanExpression op1, BooleanExpression op2){
        this.op1 = op1;
        this.op2 = op2;
        return this;
    }
            
    @Override
    public BooleanExpression build() {
        return new OrExpression(op1, op2);
    }
    
}
