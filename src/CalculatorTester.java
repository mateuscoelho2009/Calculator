import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class CalculatorTester {

	@Test
	public void addTest() {
		CalculatorEngine calcEng = new CalculatorEngine();
		
		calcEng.digit("1");
		calcEng.digit("2");
		calcEng.digit(".");
		calcEng.digit("3");
		
		calcEng.digit("+");
		
		calcEng.digit("1");
		calcEng.digit("0");
		calcEng.digit(".");
		calcEng.digit("9");
		
		calcEng.digit("=");
		
		assertEquals(calcEng.getExpression(), Double.toString(12.3+10.9));
	}

	@Test
	public void multTest() {
		CalculatorEngine calcEng = new CalculatorEngine();
		
		calcEng.digit("1");
		calcEng.digit("2");
		calcEng.digit(".");
		calcEng.digit("3");
		
		calcEng.digit("*");
		
		calcEng.digit("1");
		calcEng.digit("0");
		calcEng.digit(".");
		calcEng.digit("9");
		
		calcEng.digit("=");
		
		assertEquals(calcEng.getExpression(), Double.toString(12.3*10.9));
	}
	
	@Test
	public void potTest() {
		CalculatorEngine calcEng = new CalculatorEngine();
		
		calcEng.digit("1");
		calcEng.digit("2");
		calcEng.digit(".");
		calcEng.digit("3");
		
		calcEng.digit("^");
		
		calcEng.digit("1");
		calcEng.digit("0");
		calcEng.digit(".");
		calcEng.digit("9");
		
		calcEng.digit("=");
		
		assertEquals(calcEng.getExpression(), Double.toString(Math.pow(12.3, 10.9)));
	}
	
	@Test
	public void subTest() {
		CalculatorEngine calcEng = new CalculatorEngine();
		
		calcEng.digit("1");
		calcEng.digit("2");
		calcEng.digit(".");
		calcEng.digit("3");
		
		calcEng.digit("-");
		
		calcEng.digit("1");
		calcEng.digit("0");
		calcEng.digit(".");
		calcEng.digit("9");
		
		calcEng.digit("=");
		
		assertEquals(calcEng.getExpression(), Double.toString(12.3-10.9));
	}
	
	@Test
	public void divTest() {
		CalculatorEngine calcEng = new CalculatorEngine();
		
		calcEng.digit("1");
		calcEng.digit("2");
		calcEng.digit(".");
		calcEng.digit("3");
		
		calcEng.digit("/");
		
		calcEng.digit("1");
		calcEng.digit("0");
		calcEng.digit(".");
		calcEng.digit("9");
		
		calcEng.digit("=");
		
		assertEquals(calcEng.getExpression(), Double.toString(12.3/10.9));
	}
}
