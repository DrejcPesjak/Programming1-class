public class Kvadrat extends Pravokotnik {
		
	public Kvadrat(int a) {
		super(a,a);
	}
		
		
	@Override
	public String vrsta(){
		return "kvadrat";
	}
	
	@Override
	public String podatki(){
		return "a = " + a;
	}
	


}