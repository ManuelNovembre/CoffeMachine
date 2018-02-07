package coffeeMachine.coffeeMachine;

import org.junit.Test;
import junit.framework.TestCase;

public class DrinkMakerTest extends TestCase {
		DrinkMaker sut = new DrinkMaker("",0);
		
		@Test
		public void testSendMessage() {
			String result = sut.MakeDrink("message-content");
			assertEquals(result,"message-content");
			//fail("Not yet implemented");
		}
}
