package com.evaluator.car.custom;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fathzer.soft.javaluator.*;

@Service
public class PriceEvaluator extends AbstractEvaluator<String> {
	
  
  private final static Operator IF = new Operator("IF", 1, Operator.Associativity.RIGHT, 1);
  
  @Value("${price.evaluator.expression}")
  public static String expression;  
  
  private static final Parameters PARAMETERS;
  
  private double basePrice;
 
  static {
    PARAMETERS = new Parameters();    
    PARAMETERS.add(IF);
    PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
  }
 
  public PriceEvaluator(double basePrice) {
	  super(PARAMETERS);
	this.basePrice = basePrice;    
  }
 
  @Override
  protected String toValue(String literal, Object evaluationContext) {
    return literal;
  }
 
  @Override
  protected String evaluate(Operator operator, Iterator<String> operands, Object evaluationContext) {
    if (operator == IF) {
    	DoubleEvaluator evaluator = new DoubleEvaluator();
        final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
        variables.set("BASE_PRICE", basePrice);
        Double result = evaluator.evaluate(operands.next(),variables);
        return result.toString();
    } else {
    	return super.evaluate(operator, operands, evaluationContext);
    }
  }
}
