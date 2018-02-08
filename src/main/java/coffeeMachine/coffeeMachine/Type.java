package coffeeMachine.coffeeMachine;

public enum Type {
	TEA(1, "T", "tea", 0.4),
	CHOCOLATE(2, "H", "chocolate", 0.5),
	COFFEE(3, "C", "coffee", 0.6),
	ORANGE(4, "O", "orange juice", 0.6);

	private int id;

	String libelle;

	String label;
	
	double price;

	Type(int id,String libelle, String label, double price) {
		this.id = id;
		this.libelle = libelle;
		this.label = label;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getLabel() {
		return label;
	}

	public double getPrice() {
		return price;
	}

	public static Type getTypeFromId(String id) {
		Type type = null;
		if (TEA.libelle.equals(id)) {
			type = TEA;
		} else if (CHOCOLATE.libelle.equals(id)) {
			type = CHOCOLATE;
		} else if (COFFEE.libelle.equals(id)) {
			type = COFFEE;
		} else if(ORANGE.libelle.equals(id)){
			type = ORANGE;
		}
		return type;
	}
}
