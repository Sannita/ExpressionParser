/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sannita.exparser.expressions.booleans;

import it.sannita.exparser.Context;

public interface BooleanExpression {

    Boolean evaluate(Context context);
}
