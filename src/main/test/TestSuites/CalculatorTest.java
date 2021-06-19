package TestSuites;

import org.junit.Assert;
import org.junit.Test;

import compute.Calculator;

/**
 * @author alexgabor
 *
 */
public class CalculatorTest {

	@Test
	public void testMultiplyPositiveNumbers() {
		Calculator calculator = new Calculator();
		double actualResult = calculator.compute(3, 56, "*");

		Assert.assertEquals(168, actualResult, 0);

		double actualResultTwo = calculator.compute(0, 0, "*");

		Assert.assertEquals(0, actualResultTwo, 0);

		double actualResult3 = calculator.compute(10000, 99779, "*");

		Assert.assertEquals(997790000, actualResult3, 0);
	}

	@Test
	public void testMultiplyNegativeNumbers() {
		Calculator calculator = new Calculator();
		double actualResult = calculator.compute(-3, -56, "*");

		Assert.assertEquals("Multiplication of 2 negative numbers has failed", 168, actualResult, 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOperator() {
		Calculator calculator = new Calculator();
		double actualResult = calculator.compute(-3, -56, "h");

		Assert.assertEquals(168, actualResult, 0);

	}

	@Test
	public void testDivisionPositiveNumbers() {
		Calculator calculator = new Calculator();
		double result = calculator.compute(15, 3, "/");

		Assert.assertEquals(5, result, 0);

		// Bug - nu imparte 3 la 15
		// double result1 = calculator.compute(3, 15, "/");
		//
		// Assert.assertEquals(0.2, result, 0);

	}

	@Test
	public void testDivisionNegativeNumbers() {
		Calculator calculator = new Calculator();
		double result = calculator.compute(-15, -3, "/");

		Assert.assertEquals(5, result, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivisionByZero() {
		Calculator calculator = new Calculator();
		double result = calculator.compute(15, 0, "/");

		Assert.assertEquals("Division by Zero, IllegalArgumentException expected", 5, result, 0);
	}
}
