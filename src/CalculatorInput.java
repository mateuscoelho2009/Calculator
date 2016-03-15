import java.io.*;

class CalculatorInput {
	BufferedReader stream;
	CalculatorEngine engine;
	
	CalculatorGUI calculator;
	
	CalculatorInput(CalculatorEngine e) {
		calculator = new CalculatorGUI();
		
		InputStreamReader input = new InputStreamReader(System.in);
		stream = new BufferedReader(input);
		engine = e;
	}
	
	void run() throws Exception {
		calculator.Run();
	}
	
	public static void main(String arg[]) throws Exception {
		CalculatorEngine e = new CalculatorEngine();
		CalculatorInput calc = new CalculatorInput(e);
		
		calc.run();
		
	}
}
