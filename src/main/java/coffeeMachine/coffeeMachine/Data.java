package coffeeMachine.coffeeMachine;

public class Data {
	private int nbTea;
	private int nbCoffee;
	private int nbChocolate;
	private int nbOrange;
	private double gain;
	
	
	public Data() {
		this.nbTea = 0;
		this.nbChocolate = 0;
		this.nbCoffee = 0;
		this.nbOrange = 0;
		this.gain = 0;
	}
	
	public void update(Type type) {
		switch(type.getId()){
		case 1 :
			this.nbTea += 1;
			break;
		case 2 :
			this.nbChocolate += 1;
			break;
		case 3 :
			this.nbCoffee += 1;
			break;
		case 4 :
			this.nbOrange += 1;
			break;
		}
		this.gain += type.getPrice();
	}
	
	@Override
	public String toString() {
		return "Data [nbTea=" + nbTea + ", nbCoffee=" + nbCoffee
				+ ", nbChocolate=" + nbChocolate + ", nbOrange=" + nbOrange
				+ ", gain=" + gain + "]";
	}
	
	public int getNbTea() {
		return nbTea;
	}
	public void setNbTea(int nbTea) {
		this.nbTea = nbTea;
	}
	public int getNbCoffee() {
		return nbCoffee;
	}
	public void setNbCoffee(int nbCoffee) {
		this.nbCoffee = nbCoffee;
	}
	public int getNbChocolate() {
		return nbChocolate;
	}
	public void setNbChocolate(int nbChocolate) {
		this.nbChocolate = nbChocolate;
	}
	public int getNbOrange() {
		return nbOrange;
	}
	public void setNbOrange(int nbOrange) {
		this.nbOrange = nbOrange;
	}
	public double getGain() {
		return gain;
	}
	public void setGain(double gain) {
		this.gain = gain;
	}
}
