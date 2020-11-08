package coffeeMachine.coffeeMachine;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @author maru
 *
 */
public class DrinkMakerTest extends TestCase {

	static DrinkMaker sut = new DrinkMaker();
	
	@Test
	public void testSendMessage() {
		//Given a command with a message to foward
		String command = "M:message-content"; 
			
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
			
		//Make sure it returns the message to forward 
		String expected = "Message sent : message-content\n";
		assertEquals(expected, result);
	}

	@Test
	public void testMakeTeaWith1Sugar() {
		//Given a tea command with one sugar
		String command = "T:1:10";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make a tea with one sugar and a stick\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeTeaWithWrongSugarNumber() {
		//Given a tea command with wrong sugar number
		String command = "T:5:10";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make a tea with no sugar - and therefore no stick\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeCoffeeWith0Sugar() {
		//Given a tea command with wrong sugar number
		String command = "C:0:10";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make a coffee with no sugar - and therefore no stick\n";
		assertEquals(expected, result);
	}

	@Test
	public void testMakeChocolateWith0Sugar() {
		//Given a tea command with wrong sugar number
		String command = "H::10";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make a chocolate with no sugar - and therefore no stick\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeTeaWithEnoughMoney() {
		//Given a tea command with enough money
		String command = "T:1:0.4";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make a tea with one sugar and a stick\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeTeaWithoutEnoughMoney() {
		//Given a tea command without enough money
		String command = "T:1:0.34";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "there is not enough money put : 0,06 euros.\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testWithWrongDrinkType() {
		//Given a tea command with wrong sugar number
		String command = "Z::10";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Wrong drink type has been choosed.\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testWithoutEnoughDetails() {
		//Given a tea command with wrong sugar number
		String command = "Z::";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Error with the command.\n";
		assertEquals(expected, result);
	}
	
	
	
	@Test
	public void testMakeOrangeJuice() {
		//Given a tea command with wrong sugar number
		String command = "O::0.6";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make one orange juice\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeExtraHotTea() {
		//Given a tea command with wrong sugar number
		String command = "Th:1:0.4";
		
		//When calling MakeDrink
		String result = sut.MakeDrink(command);
		
		//Make sure it returns the right command
		String expected = "Drink maker will make an extra hot tea with one sugar and a stick\n";
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetData (){
		DrinkMaker sut = new DrinkMaker();
		String command = "T:1:0.4";
		String result = sut.MakeDrink(command);
		
		 command = "Th:1:0.4";
		 result = sut.MakeDrink(command);
		
		 command = "O:1:0.6";
		 result = sut.MakeDrink(command);
		
		 result = sut.displayData();
		 
		String expected = "Data [nbTea=" + 2 + ", nbCoffee=" + 0
				+ ", nbChocolate=" + 0 + ", nbOrange=" + 1
				+ ", gain=" + 1.4 + "]\n";
		
		assertEquals(expected, result);
	}
	
}
