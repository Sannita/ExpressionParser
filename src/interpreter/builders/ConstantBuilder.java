/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.builders;

import interpreter.BooleanExpression;
import interpreter.Constant;

/**
 *
 * @author llupacchino
 */
public class ConstantBuilder implements ExpressionBuilder{
    private static final Constant TRUE = new Constant(true);
    private static final Constant FALSE = new Constant(false);
    
    private Boolean value;
    
    public ConstantBuilder(){
        
    }
    
    public ConstantBuilder withValue(String value){
        this.value = Boolean.valueOf(value);
        return this;
    }

    @Override
    public BooleanExpression build() {
        if(value){
            return TRUE;
        }else{
            return FALSE;
        }
    }
    
}
