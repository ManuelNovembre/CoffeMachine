package coffeeMachine.coffeeMachine;

import org.junit.Test;
import junit.framework.TestCase;

public class DrinkMakerTest extends TestCase {

	DrinkMaker sut = new DrinkMaker();
		
	@Test
	public void testSendMessage() {
		//Given a command with a message to foward
		String command = "M:message-content"; 
			
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
			
		//Make sure it returns the message to forward 
		String expected = "Message sent : message-content";
		assertEquals(result, expected);
	}

	@Test
	public void testMakeTeaWith1Sugar() {
		//Given a tea command with 1 sugar
		String command = "T:1:0";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker makes 1 tea with 1 sugar and a stick";
		assertEquals(result, expected);
	}
	
	@Test
	public void testMakeTeaWithWrongSugarNumber() {
		//Given a tea command with wrong sugar number
		String command = "T:5:";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker makes 1 tea with no sugar - and therefore no stick";
		assertEquals(result, expected);
	}
	
	@Test
	public void testMakeCoffeeWith0Sugar() {
		//Given a tea command with wrong sugar number
		String command = "C:0:";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker makes 1 coffee with no sugar - and therefore no stick";
		assertEquals(result, expected);
	}

	@Test
	public void testMakeChocolateWith0Sugar() {
		//Given a tea command with wrong sugar number
		String command = "H::";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker makes 1 chocolate with no sugar - and therefore no stick";
		assertEquals(result, expected);
	}
}
