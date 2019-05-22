/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.builders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Symbol {
    private final String name;
    private final int priority;
    private final Associativity associativity;
    private final Type type;

    private Symbol(String name, int priority, Associativity associativy, Type type) {
        this.name = name;
        this.priority = priority;
        this.associativity = associativy;
        this.type = type;
    }
    
    public static Symbol newOperand(String name){
        return new Symbol(name, 0, Associativity.NONE, Type.OPERAND);
    }
    
    public static Map<String, Symbol> configSymbols(String fileName){
        Map<String, Symbol> table = new HashMap<>();
        List<String> lines = readFile(fileName);
        for(String line : lines){
            String[] tmp = line.split(";");
            Symbol s = new Symbol(tmp[1], Integer.valueOf(tmp[2]), Associativity.valueOf(tmp[3]), Type.valueOf(tmp[4]));
            table.put(tmp[1], s);
        }
        return table;
    }
    
    private static List<String> readFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            List<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException ex) {
            Logger.getLogger(Symbol.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean isOperator() {
        return type == Type.OPERATOR;
    }

    public boolean isOperand() {
        return type == Type.OPERAND;
    }

    public boolean isLeftParenthesis() {
        return type == Type.LEFT_PARENTHESIS;
    }

    public boolean isRightParenthesis() {
        return type == Type.RIGHT_PARENTHESIS;
    }

    public boolean isLeftAssociative() {
        return associativity == Associativity.LEFT;
    }

    public boolean isRightAssociative() {
        return associativity == Associativity.RIGHT;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /*
    @Override
    public String toString() {
        return "Operator{" + "name=" + name + ", priority=" + priority + ", associativity=" + associativity + '}';
    }
     */
    public enum Associativity {
        LEFT, RIGHT, NONE;
    }

    public enum Type {
        OPERATOR, OPERAND, RIGHT_PARENTHESIS, LEFT_PARENTHESIS, NONE;
    }
}
