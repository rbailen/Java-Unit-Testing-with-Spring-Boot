package com.rbailen.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10, \"quantity\":100}";
		
		// strict true means that spaces can be different but the exact structure should match
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10}";
		
		// strict false means that the structure could be different, but same values
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1, name:Ball, price:10}";
		
		// JSONAssert does not need escape characters
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_WithEscapeCharacters() throws JSONException {
		actualResponse = "{\"id\":1,\"name\":\"Ball 2\",\"price\":10,\"quantity\":100}";
		String expectedResponse = "{id:1, name:\"Ball 2\", price:10}";
		
		// We have to escape something when you have space in the value (Ball 2)
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
}
