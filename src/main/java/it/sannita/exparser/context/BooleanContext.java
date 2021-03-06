/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.context;

import it.sannita.exparser.model.booleans.VariableExpression;

import java.util.HashMap;
import java.util.Map;

public final class BooleanContext {
    private final Map<String, Boolean> variables;
    
    public BooleanContext(){
        this.variables = new HashMap<>();
    }
    
    public void assign(VariableExpression var, Boolean value){
        variables.put(var.getVariableName(), value);
    }
    
    public void assign(String var, Boolean value){
        variables.put(var, value);
    }
    
    public Boolean lookup(String variableName){
        return variables.get(variableName);
    }
}
