package com.ananth;


import java.util.Stack;

/***
 * Write a program to evaluate arithmetic expressions of the form 3 + 4  or (3+4) - 5 or (8+(3+2))-9 etc. 
 * @author ananth
 *
 */
public class EvalArithExpression {
	
	public static final Character PLUS = '+';
	public static final Character MINUS = '-';
	
	public int evaluateExpr(String expr){
		
		Stack<Integer> operands = new Stack<Integer>();
		
		Stack<Character> operators = new Stack<Character>();
		
		for(int i=0;i<expr.length();i++){
			
			char c = expr.charAt(i);
			
			if(c == PLUS){
				operators.push(PLUS);
			}else if(c==MINUS){
				operators.push(MINUS);
			}else if(c=='('){
				continue;
			}else if(c==')'){
				operate(operators, operands);
			}else{
				operands.push(Character.getNumericValue(c));
			}
			
			
		}
		
		
		while(!operators.isEmpty() && !operands.isEmpty()){
			
			operate(operators,operands);
		}
		
		return operands.pop();
		
		
		
	}
	
	private void operate(Stack<Character> operators,Stack<Integer> operands){
		Character operator = operators.pop();
		int operand2 = operands.pop();
		int operand1 = operands.pop();
		
		int result = 0;
		
		if(operator == PLUS){
			result = operand1 + operand2;
		}else{
			result = operand1  - operand2;
		}
		operands.push(result);
	}

}
