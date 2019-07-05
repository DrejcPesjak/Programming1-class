public class Pravokotnik extends Lik {
	protected int a;
	private int b;
	
	
	public Pravokotnik(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int racunajPloscino(){
		return a*b;
	}
	
	@Override
	public int racunajObseg(){
		return 2*a + 2*b;
	}
	
	@Override
	public String vrsta(){
		return "pravokotnik";
	}
	
	@Override
	public String podatki(){
		return "a = " + a + ", b = " + b;
	}
	


}