package com.rbailen.unittesting.unittesting.business;

import org.junit.Assert;
import org.junit.Test;

import com.rbailen.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService(){
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		
		Assert.assertEquals(expectedResult, actualResult);
		
	}
}
