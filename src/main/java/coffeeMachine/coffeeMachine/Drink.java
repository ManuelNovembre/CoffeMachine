package coffeeMachine.coffeeMachine;

public class Drink {
	private Type type;
	private int sugar;

	public static enum Type {
		TEA("T", "tea"),
		CHOCOLATE("H", "chocolate"),
		COFFEE("C", "coffee");

		String id;

		String label;

		Type(String id, String label) {
			this.id = id;
			this.label = label;
		}

		public String getId() {
			return id;
		}

		public String getLabel() {
			return label;
		}

		public static Type getHeaderFromId(String id) {
			Type type = null;
			if (TEA.id.equals(id)) {
				type = TEA;
			} else if (CHOCOLATE.id.equals(id)) {
				type = CHOCOLATE;
			} else if (COFFEE.id.equals(id)) {
				type = COFFEE;
			}
			return type;
		}
	}

	//constructor
	public Drink(Type type, int sugar) {
		super();
		this.type = type;
		this.sugar = sugar;
	}

	/**
	 * @return
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(Type type) {
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
		String result = null; 
		switch(this.sugar){
			case 0 :
				result = this.type.getLabel() + " with no sugar - and therefore no stick";
				break;
			default : 
			result = this.type.getLabel() + " with " + this.sugar + " sugar and a stick";
				break;
		}
		return result;
	}
}
