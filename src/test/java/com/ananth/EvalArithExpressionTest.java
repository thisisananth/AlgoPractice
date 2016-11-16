package com.ananth;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvalArithExpressionTest {
	
	EvalArithExpression expr = null;

	@Before
	public void setUp() throws Exception {
		 expr = new EvalArithExpression();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testEvaluateExpr() {
		assertTrue(expr.evaluateExpr("3+4")==7);
		assertTrue(expr.evaluateExpr("(3+4)-5")==2);
		assertTrue(expr.evaluateExpr("(8+(3+2))-9")==4);
		assertTrue(expr.evaluateExpr("(2+3)")==5);
		assertFalse(expr.evaluateExpr("(3+4)")==5);
	}

}
