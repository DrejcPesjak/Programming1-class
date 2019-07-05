import Math;

public class Krog extends Lik {
	private int r;
	
	public Krog(int r) {
		this.r = r;
	}
	
	@Override
	public int racunajPloscino(){
		return (int)(Math.PI*r*r);
	}
	
	@Override
	public int racunajObseg(){
		return (int)(2*Math.PI*r);
	}
	
	@Override
	public String vrsta(){
		return "krog";
	}
	
	@Override
	public String podatki(){
		return "r = " + r;
	}
	


}