package org.afmejia.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 5});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24, result);
	}
	
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(15, result);
	}
	
	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}

}
