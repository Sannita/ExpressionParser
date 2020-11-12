/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.context;

import it.sannita.exparser.model.fuzzy.VariableExpression;

import java.util.HashMap;
import java.util.Map;

public final class FuzzyContext {
    private final Map<String, Double> variables;

    public FuzzyContext(){
        this.variables = new HashMap<>();
    }
    
    public void assign(VariableExpression var, Double value){
        variables.put(var.getVariableName(), value);
    }
    
    public void assign(String var, Double value){
        variables.put(var, value);
    }
    
    public Double lookup(String variableName){
        return variables.get(variableName);
    }
}
