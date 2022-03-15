package com.evaluator.car.custom;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fathzer.soft.javaluator.*;

@Service
public class OffRoadCostEvaluator extends AbstractEvaluator<String> {

  @Value("${offroad.cost.evaluator.expression}")
  public static String expression;

  public final static Operator IF = new Operator("IF", 1, Operator.Associativity.RIGHT, 1);
  
  private static final Parameters PARAMETERS;
  
  private int noOfWheelsDrive;
 
  static {
    PARAMETERS = new Parameters();    
    PARAMETERS.add(IF);
    PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
  }
 
  public OffRoadCostEvaluator(int noOfWheelsDrive) {
    super(PARAMETERS);
    this.noOfWheelsDrive = noOfWheelsDrive;
  }
 
  @Override
  protected String toValue(String literal, Object evaluationContext) {
    return literal;
  }
 
  @Override
  protected String evaluate(Operator operator, Iterator<String> operands, Object evaluationContext) {
    if (operator == IF) {
    	DoubleEvaluator evaluator = new DoubleEvaluator();
        final StaticVariableSet<Integer> variables = new StaticVariableSet<Integer>();
        variables.set("NO_WHEEL_DRIVE", noOfWheelsDrive);
        Double result = evaluator.evaluate(operands.next(),variables);
        return result.toString();
    } else {
    	return super.evaluate(operator, operands, evaluationContext);
    }
  }
}
