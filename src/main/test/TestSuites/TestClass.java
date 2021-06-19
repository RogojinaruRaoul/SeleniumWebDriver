package TestSuites;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClass {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before all tests in class.");
	}

	@Before
	public void before() {
		System.out.println("Before each test.");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After all tests in class.");
	}

	@After
	public void after() {
		System.out.println("After each tests.");
	}

	@Test
	public void test1() {
		System.out.println("Test 1.");
	}

	@Test
	public void test2() {
		System.out.println("Test 2.");
	}

	@Test
	public void test3() {
		System.out.println("Test 3.");
	}

}
