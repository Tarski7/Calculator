package test.calculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {

	public static ArrayList<String> testList() {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("add");
		list.add("2");
		list.add("multiply");
		list.add("3");
		list.add("apply");
		list.add("10");
		return list;
	}
	
	@Test
	public void testGetList() {
		final ArrayList<String> actual = Calculator.getList();
		assertEquals(testList(), actual);
	}
	
	@Test
	public void testGetOutput() {
		final int actual = Calculator.getOutput(testList());
		assertEquals(36, actual);
	}
}
