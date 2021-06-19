package compute;

import static compute.Calculator.SQRT;

/**
 * @author alexgabor
 *
 */
public class Runnable {

	public static void main(String[] args) {

		if (args.length == 3 || args.length == 2 && args[1].equals(SQRT)) {

			double d1 = Double.parseDouble(args[0]);
			double d2 = args[1].equals(SQRT) ? 0 : Double.parseDouble(args[2]);
			String operator = args[1];

			double result = new Calculator().compute(d1, d2, operator);

			System.out.println(d1 + " " + operator + " " + d2 + " = " + result);

		} else {
			System.err.println("Please use the following syntax by providing the necessary params: <operand1> <operator> <operand2>");
		}
	}

}
