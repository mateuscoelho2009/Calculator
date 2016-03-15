public class CalculatorEngine {
	/*private String expression;
 	private double atuNumber;
	private int pot;*/
	
	private double atuNumber, lastNumber;
	private char op;
	private double pot;
 	
	private void compute() {
		if (lastNumber == 0)
			return;
		
		if (op == '+')
			atuNumber += lastNumber;
		else if (op == '-')
			atuNumber = lastNumber - atuNumber;
		else if (op == '*')
			atuNumber *= lastNumber;
		else if (op == '/')
			atuNumber = lastNumber / atuNumber;
		else if (op == '^')
			atuNumber = Math.pow(lastNumber, atuNumber);
		
		
		lastNumber = 0;
		op = '0';
	}
	
	private void clear() {
		atuNumber = 0;
		op = '0';
		lastNumber = 0;

		clearPot();
	}
	
	private void clearPot() {
		pot = 1;
	}
	
	public void digit (String digit) {
		char c = digit.charAt(0);
		
		if (c >= '0' && c <= '9') {
			if (pot >= 1) {
				atuNumber *= 10;
				atuNumber += c - '0';
			}
			else {
				atuNumber += (c - '0') * pot;
				pot *= 0.1;
			}
			
			return;
		}
		
		if (c == '-') {
			compute ();
			clearPot();
			op = '-';
			lastNumber = atuNumber;
			atuNumber = 0;
		}
		else if (c == '+') {
			compute ();
			clearPot();
			op = '+';
			lastNumber = atuNumber;
			atuNumber = 0;
		}
		else if (c == '*') {
			compute ();
			clearPot();
			op = '*';
			lastNumber = atuNumber;
			atuNumber = 0;
		}
		else if (c == '/') {
			compute ();
			clearPot();
			op = '/';
			lastNumber = atuNumber;
			atuNumber = 0;
		}
		else if (c == '^') {
			compute ();
			clearPot();
			op = '^';
			lastNumber = atuNumber;
			atuNumber = 0;
		}
		else if (c == '<') {
			
		}
		else if (c == 'C') {
			clear ();
		}
		else if (c == '=') {
			compute();
			pot = 0;
			
			return;
		}
		else if (c == '.') {
			if (pot == 0)
				return;
			
			pot = 0.1;
			
			return;
		}
	}
	
	public String getExpression () {
		return Double.toString(atuNumber);
	}
	
	public CalculatorEngine() {		
		clear();
	}
}
