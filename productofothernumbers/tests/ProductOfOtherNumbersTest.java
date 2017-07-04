package productofothernumbers.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import productofothernumbers.ProductOfOtherNumbers;

public class ProductOfOtherNumbersTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ProductOfOtherNumbers problem = new ProductOfOtherNumbers();
		int[] data = {1,7,3,4};
		int[] solution = problem.getProduct(data);
		int[] correctData = {84,12,28,21};
		
		assertArrayEquals(solution, correctData);
	}
	
	@Test
	public void testNull(){
		ProductOfOtherNumbers problem = new ProductOfOtherNumbers();
		problem.getProduct(null);
	}
	
	@Test
	public void testArrayVariations(){
		ProductOfOtherNumbers problem = new ProductOfOtherNumbers();
		int[] data = {};
		int[] solution = problem.getProduct(data);
		int[] correctData = {};
		
		assertArrayEquals(solution, correctData);
	}

}
