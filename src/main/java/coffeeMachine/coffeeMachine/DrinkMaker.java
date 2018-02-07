package coffeeMachine.coffeeMachine;

public class DrinkMaker {
	private String type;
	private int sugar;
	
	//constructor
	public DrinkMaker(String type, int sugar) {
		super();
		this.type = type;
		this.sugar = sugar;
	}
	
	/**
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	public int getSugar() {
		return sugar;
	}
	/**
	 * @param sugar
	 */
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	@Override
	public String toString() {
		return "DrinkMaker [type=" + type + ", sugar=" + sugar + "]";
	}
	
	public String MakeDrink(){
		return this.toString();
	}
	
	public String MakeDrink(String message){
		return message;
	}
	
}