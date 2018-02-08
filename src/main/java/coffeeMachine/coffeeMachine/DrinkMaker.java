package coffeeMachine.coffeeMachine;

import java.text.DecimalFormat;

import coffeeMachine.coffeeMachine.Drink.Sugar;
import coffeeMachine.coffeeMachine.Drink.Type;

public class DrinkMaker {
	private Drink drink;

	public DrinkMaker() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb;
		Type type = this.drink.getType();
		
		if(type.equals(Type.ORANGE)){
			sb = new StringBuilder("Drink maker will make one ").append(drink.toString()).append("\n");
		} else if (drink.isExtraHot()){
			sb = new StringBuilder("Drink maker will make an extra hot").append(" ").append(drink.toString()).append("\n");
		}else{
			sb = new StringBuilder("Drink maker will make a ").append(drink.toString()).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Prepare a drink
	 * @param command
	 * "<type of drink> : <number of sugar>"
	 * @return
	 */
	public String MakeDrink(String command) {
		String[] details = command.split(":");
		StringBuilder response = null;
		
		if(details.length <= 1){
			response = new StringBuilder("Error with the command.\n");
			return response.toString();
		}
		
		boolean xtraHot = false;
		String _type;
		if(details[0].contains("h") && details[0].length() == 2){
			xtraHot = true;
			_type = details[0].substring(0, 1);
		}else{
			_type = details[0];
		}
		//if user want to forwards a message to the coffee machine
		if (_type.equals("M")) {
			response = new StringBuilder("Message sent : ").append(details[1]).append("\n");
			return response.toString();
		} else {
			Type type = Type.getTypeFromId(_type);
			if(type == null){
				response = new StringBuilder("Wrong drink type has been choosed.\n");
				return response.toString();
			}
			
			double money = Double.parseDouble( details[2].replace(",","."));  
			double moneyNeeded = type.getPrice();
			
			// Check if the customer put enough money
			if(money < moneyNeeded){
				double moneyMissing = moneyNeeded - money;
				DecimalFormat df = new DecimalFormat("#.##");
				response = new StringBuilder("there is not enough money put : ").append(df.format(moneyMissing)).append(" euros.\n");
				System.out.print(response.toString());
				return response.toString();
			}
			
			int nbSugar;
			Sugar sugar = null;
			//if number sugar is not defined in the command put it to 0
			if(details.length <= 1 || details[1].isEmpty()){
				nbSugar = 0;
			}else{
				nbSugar = Integer.valueOf(details[1]);
				
				// Check if sugar is between  and 2
				if (nbSugar < 0 || nbSugar>2){
					nbSugar = 0;
					System.out.print("The number of sugar must be between 0 and 2.\n");
				}
			}
			sugar = Sugar.getSugarFromNumber(nbSugar);
			
			//Create drink
			this.drink = new Drink(type, sugar, xtraHot);
		}
		System.out.print(this.toString());
		return this.toString();
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}
}