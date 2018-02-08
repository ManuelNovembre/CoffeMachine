package coffeeMachine.coffeeMachine;

public class Drink {
	private Type type;
	private Sugar sugar;
	private boolean extraHot;
	
	public static enum Sugar{
		NONE(0, ""),
		ONE(1, "one"),
		TWO(2, "two");
		
		int number;
		
		String label;
		
		Sugar(int number, String label) {
			this.number = number;
			this.label = label;
		}

		public int getNumber() {
			return number;
		}
		
		public String getLabel() {
			return label;
		}
		
		public static Sugar getSugarFromNumber(int number) {
			Sugar sugar = null;
			if (ONE.number == number) {
				sugar = ONE;
			} else if (TWO.number == number) {
				sugar = TWO;
			}
			return sugar;		
		}
	}
	
	//constructor
	public Drink(Type type, Sugar sugar, boolean extraHot) {
		super();
		this.type = type;
		this.sugar = sugar;
		this.extraHot = extraHot;
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

	public Sugar getSugar() {
		return sugar;
	}

	/**
	 * @param sugar
	 */
	public void setSugar(Sugar sugar) {
		this.sugar = sugar;
	}

	public boolean isExtraHot() {
		return extraHot;
	}

	public void setExtraHot(boolean extraHot) {
		this.extraHot = extraHot;
	}

	@Override
	public String toString() {
		StringBuilder result; 
		if(this.type.equals(Type.ORANGE)){
			result = new StringBuilder(this.type.getLabel());
		} else {
			if(this.sugar == null){
				result = new StringBuilder(this.type.getLabel()).append(" with no sugar - and therefore no stick");
			}
			else {
				switch(this.sugar.getNumber()){
					case 0 :
						result = new StringBuilder(this.type.getLabel()).append(" with no sugar - and therefore no stick");
						break;
					default : 
						result = new StringBuilder(this.type.getLabel()).append(" with ").append(this.sugar.getLabel()).append(" sugar and a stick");
						break;
				}				
			}
		}
		return result.toString();
	}
}
