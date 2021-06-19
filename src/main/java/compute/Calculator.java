package compute;

/**
 * This class is numerical Calculator that implements the following Operators:
 * <ul>
 * <li>ADD - +
 * <li>DIFFERENCE - -
 * <li>MULTIPLY - *
 * <li>SQRT
 * <li>DIVIDE - /
 * </ul>
 * <p>
 * The operands can be any double number.
 * <p>
 * <b>Current implementation supports only two operands. </b> Sample input: {@code Calculator 1 + 2, having the output 1 + 2 = 3.}
 *
 * @author alexgabor
 *
 */
public class Calculator {

	public static final String SQRT = "SQRT";

	/**
	 * Returns the result of the calculation of two doubles using the operation indicated by the operator.
	 *
	 * @param d1
	 *        first operand
	 * @param d2
	 *        second operand - In case of SQRT operator this param is ignored.
	 * @param operator
	 *        the operator to apply. It can be one of: +, -, /, *, SQRT
	 */
	public double compute(double d1, double d2, String operator) throws IllegalArgumentException {

		double result = 0;

		switch (operator) {
		case "+":

			result = d1 + d2;

			break;

		case "-":

			result = d1 - d2;

			break;

		case "*":

			result = d1 * d2;

			break;

		case "/":

			if (d2 == 0) {
				throw new IllegalArgumentException("Division by ZERO");
			}

			result = d1 / d2;

			break;

		case SQRT:

			result = Math.sqrt(d1);

			break;

		default:
			throw new IllegalArgumentException("Unsupported operator: " + operator);

		}

		return result;
	}
}
