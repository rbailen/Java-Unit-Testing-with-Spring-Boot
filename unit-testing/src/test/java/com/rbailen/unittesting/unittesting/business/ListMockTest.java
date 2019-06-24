package com.rbailen.unittesting.unittesting.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;

public class ListMockTest {
	
	List<String> mock = Mockito.mock(List.class);

	@Test
	public void size(){
	
		when(mock.size()).thenReturn(5);
		Assert.assertEquals(5, mock.size());
		
	}
	
	@Test
	public void returnDifferetValues(){
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		Assert.assertEquals(5, mock.size());
		Assert.assertEquals(10, mock.size());
		
	}
	
	@Test
	public void returnWithParameters(){
		
		when(mock.get(0)).thenReturn("rbailen");
		Assert.assertEquals("rbailen", mock.get(0));
		Assert.assertEquals(null, mock.get(1));
		
	}
	
	@Test
	public void returnWithGenericParameters(){
		
		when(mock.get(Mockito.anyInt())).thenReturn("rbailen");
		Assert.assertEquals("rbailen", mock.get(0));
		Assert.assertEquals("rbailen", mock.get(1));
		
	}
	
	@Test
	public void firstVerification(){
		
		String value = mock.get(0);
		
		verify(mock).get(0);
		verify(mock).get(Mockito.anyInt());
		
		verify(mock, times(1)).get(0);
		
	}
	
	@Test
	public void secondVerification(){
		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		
		verify(mock, times(2)).get(Mockito.anyInt());
		verify(mock, atLeast(1)).get(0);
		verify(mock, atLeast(1)).get(1);
		verify(mock, atLeastOnce()).get(Mockito.anyInt());
		verify(mock, atMost(2)).get(Mockito.anyInt());
		verify(mock, atMost(2)).get(Mockito.anyInt());
		verify(mock, never()).get(2);
		
	}
	
	@Test
	public void argumentCapturing(){
		
		mock.add("SomeString");
		
		// Capturar los argumentos que se pasan en un mock
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		Assert.assertEquals("SomeString", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing(){
		
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		// Capturar los argumentos que se pasan en un mock
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		Assert.assertEquals("SomeString1", allValues.get(0));
		Assert.assertEquals("SomeString2", allValues.get(1));
		
	}
	
	@Test
	public void withoutSpying(){
		
		ArrayList arrayListSpy = Mockito.mock(ArrayList.class);
		
		System.out.println(arrayListSpy.get(0));//null
		System.out.println(arrayListSpy.size());//0
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		
		// Un mock no conserva el comportamiento de la clase original
		// Por eso, a pesar de añadir dos elementos, el tamaño de la lista sigue siendo 0
		System.out.println(arrayListSpy.size());//0
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
	}
	
	@Test
	public void withSpying(){
		
		// Un spy, por defecto, conserva el comportamiento de la clase original
		ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
		arrayListSpy.add("Test0");
		
		// Si no hubiera añadido un elemento daría en este caso una excepción
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
		
	}
}
