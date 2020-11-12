/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.builders;

import it.sannita.exparser.BooleanExpression;
import it.sannita.exparser.VariableExpression;

public class VariableBuilder implements ExpressionBuilder{

    private String name;
    
    public VariableBuilder(){
        
    }
    
    public VariableBuilder withName(String name){
        this.name = name;
        return this;
    }

    @Override
    public BooleanExpression build() {
        return new VariableExpression(name);
    }
    
}
