package com.rbailen.unittesting.unittesting.business;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rbailen.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService service;

	@Test
	public void calculateSumUsingDataService(){
		
		when(service.retrieveAllData()).thenReturn(new int[] {1,2,3});
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		
		Assert.assertEquals(expectedResult, actualResult);
		
	}
}
