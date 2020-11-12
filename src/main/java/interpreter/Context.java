/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Boolean> variables;
    
    public Context(){
        this.variables = new HashMap<>();
    }
    
    public void assign(VariableExpression var, Boolean value){
        variables.put(var.getVariableName(), value);
    }
    
    public void assign(String var, Boolean value){
        variables.put(var, value);
    }
    
    public boolean lookup(String variableName){
        return variables.get(variableName);
    }
}
