package com.aryan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;


class MathUtilsTest {
	
	MathUtils mUtil;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mUtil = new MathUtils();
	}
	
	
	@Nested
	@DisplayName("add method")
	class AddTest {
		
		@Test
		@DisplayName("When adding two positive numbers")
		void testSumPositive() {
			int expected = 2;
			int actual = mUtil.sum(1,1);
			assertEquals(actual, expected, "Should return right sum");
		}
		
		@Test
		@DisplayName("When adding two negative numbers")
		void testSumNegative() {
			int expected = -2;
			int actual = mUtil.sum(-1,-1);
			assertEquals(actual, expected, "Should return right sum");
		}
	}
	
	
	@AfterAll
	static void clean() {
		System.out.println("Cleaning up....");
	}
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to be run before all");
	}

	
	@Test
	@DisplayName("sum method is getting tested")
	@Tag("Math")
	void testSum() {
		int expected = 2;
		int actual = mUtil.sum(1,1);
		assertEquals(actual, expected, "The add method should add two numbers");
	}
	
	@Test
	@DisplayName("multiply test")
	@Tag("Math")
	void testMultiply() {
//		System.out.println("Running "+ testInfo.getDisplayName() + " with tags "+testInfo.getTags());
		testReporter.publishEntry("Running "+ testInfo.getDisplayName() + " with tags "+testInfo.getTags());
		assertAll(
				() -> assertEquals(4, mUtil.multiply(2, 2)), 
				() -> assertEquals(-2, mUtil.multiply(2, -1)), 
				() -> assertEquals(0, mUtil.multiply(2, 0))
				);
	}
	
	@Test
	@Tag("Circle")
	void testComputeCircleArea() {
		double expected = 314.1592653589793;
		double actual = mUtil.computeCircleArea(10);
		assertEquals(expected, actual, "Calculate area of circle");
	}
	
	@Test
	@DisabledOnOs(OS.WINDOWS)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mUtil.divide(1, 0), "divide by zero should throw");
	}
	
	@Test
	@DisplayName("This test has disabled")
	@Disabled
	void disabled() {
		fail("This test has disabled");
	}
}
