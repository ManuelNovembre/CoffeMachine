package coffeeMachine.coffeeMachine;

import coffeeMachine.coffeeMachine.Drink.Type;

public class DrinkMaker {
	private Drink drink;
	private int nbDrink;

	public DrinkMaker() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Drink maker makes ").append(nbDrink).append(" ").append(drink.toString());
		return sb.toString();
	}
	
	public String MakeDrink(String command) {
		String[] details = command.split(":");

		if (details[0].equals("M")) {
			StringBuilder sb = new StringBuilder("Message sent : ").append(details[1]);
			return sb.toString();
		} else {
			Type type = Type.getHeaderFromId(details[0]);
			int sugar = Integer.valueOf(details[1]);
			this.drink = new Drink(type, sugar);
			this.nbDrink = 1;
		}
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