package com.rbailen.unittesting.unittesting.business;

import org.junit.Assert;
import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSum(){
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		int actualResult = business.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		
		Assert.assertEquals(expectedResult, actualResult);
		
	}
}
