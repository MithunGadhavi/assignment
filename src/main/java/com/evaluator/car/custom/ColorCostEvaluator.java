package com.evaluator.car.custom;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fathzer.soft.javaluator.*;

@Service
public class ColorCostEvaluator extends AbstractEvaluator<String> {

  @Value("${color.cost.evaluator.expression}")
  public static String expression;
	
  public final static Operator IF = new Operator("IF", 1, Operator.Associativity.RIGHT, 1);
  
  private String color = "";
  
  private static final Parameters PARAMETERS;
 
  static {
    PARAMETERS = new Parameters();    
    PARAMETERS.add(IF);
    PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
  }
 
  public ColorCostEvaluator(String color) {
    super(PARAMETERS);
    this.color = color;
  }
 
  @Override
  protected String toValue(String literal, Object evaluationContext) {
    return literal;
  }
 
  @Override
  protected String evaluate(Operator operator, Iterator<String> operands, Object evaluationContext) {
    if (operator == IF) {
    	DoubleEvaluator evaluator = new DoubleEvaluator();
        final StaticVariableSet<String> variables = new StaticVariableSet<String>();
        variables.set("COLOR", color);
        Double result = evaluator.evaluate(operands.next(),variables);
        return result.toString();
    } else {
    	return super.evaluate(operator, operands, evaluationContext);
    }
  }
}
