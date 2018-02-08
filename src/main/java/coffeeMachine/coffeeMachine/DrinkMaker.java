package coffeeMachine.coffeeMachine;

import java.text.DecimalFormat;

import coffeeMachine.coffeeMachine.Drink.Type;

public class DrinkMaker {
	private Drink drink;
	private int nbDrink;

	public DrinkMaker() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Drink maker makes ").append(nbDrink).append(" ").append(drink.toString()).append("\n");
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
		String _type = details[0];
		StringBuilder response;
		//if user want to forwards a message to the coffee machine
		if (_type.equals("M")) {
			response = new StringBuilder("Message sent : ").append(details[1]).append("\n");
			return response.toString();
		} else {
			Type type = Type.getHeaderFromId(_type);
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
			
			int sugar;
			//if number sugar is not defined in the command put it to 0
			if(details.length <= 1){
				sugar = 0;
			}else{
				sugar = Integer.valueOf(details[1]);
				
				// Check if sugar is between  and 2
				if (sugar < 0 || sugar>2){
					sugar = 0;
					System.out.print("The number of sugar must be between 0 and 2.\n");
				}
			}
			
			//Create drink
			this.drink = new Drink(type, sugar);
			this.nbDrink = 1;
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

	public int getNbDrink() {
		return nbDrink;
	}

	public void setNbDrink(int nbDrink) {
		this.nbDrink = nbDrink;
	}
	
}