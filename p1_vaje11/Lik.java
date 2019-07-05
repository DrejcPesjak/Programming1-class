public abstract class Lik {
		
	public abstract int racunajPloscino();
	public abstract int racunajObseg();
	
	
	@Override
	public String toString(){
		return String.format("%s [%s] | p = %d, o = %d", vrsta(), podatki(), racunajPloscino(), racunajObseg());
	}
	
	public abstract String vrsta();
	public abstract String podatki();
	
}