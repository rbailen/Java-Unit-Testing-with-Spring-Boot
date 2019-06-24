package com.rbailen.unittesting.unittesting.business;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rbailen.unittesting.unittesting.data.ItemRepository;
import com.rbailen.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	ItemBusinessService itemBusiness;
	
	@Mock
	ItemRepository repository;

	@Test
	public void retrieveAllItems(){
		
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10), 
						      new Item(3,"Item3", 20, 20)));
		
		List<Item> items = itemBusiness.retrieveAllItems();
		
		Assert.assertEquals(100, items.get(0).getValue());
		Assert.assertEquals(400, items.get(1).getValue());
		
	}
}
