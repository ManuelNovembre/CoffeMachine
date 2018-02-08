package coffeeMachine.coffeeMachine;

import org.junit.Test;
import junit.framework.TestCase;

public class DrinkMakerTest extends TestCase {

	DrinkMaker sut = new DrinkMaker();
		
		@Test
		public void testSendMessage() {
		String result = sut.MakeDrink("M:message-content");
		assertEquals(result, "Message sent : message-content");
		}

	@Test
	public void testMakeTeaWith1Sugar() {
		String result = sut.MakeDrink("T:1:0");
		assertEquals(result, "Drink maker makes 1 tea with 1 sugar and a stick");
	}

	@Test
	public void testMakeTeaWith0Sugar() {
		String result = sut.MakeDrink("T:0:0");
		assertEquals(result, "Drink maker makes 1 tea with no sugar - and therefore no stick");
	}

	@Test
	public void testMakeCoffeeWith0Sugar() {
		String result = sut.MakeDrink("C:0:0");
		assertEquals(result, "Drink maker makes 1 coffee with no sugar - and therefore no stick");
	}

	@Test
	public void testMakeChocolateWith0Sugar() {
		String result = sut.MakeDrink("C:0:0");
		assertEquals(result, "Drink maker makes 1 coffee with no sugar - and therefore no stick");
	}
}
