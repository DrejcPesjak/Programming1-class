import java.util.Scanner;
import java.util.ArrayList;

public class DN09_63180224 {
	
	static ArrayList<Ukazi> akcije = new ArrayList<Ukazi>();
	static ArrayList<Ukazi> izbrisani = new ArrayList<Ukazi>();
	static ArrayList<String> dokument = new ArrayList<String>();
	static int porabaSum = 0;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char ukazC = sc.next().charAt(0);

		do{

			if(ukazC == '#'){
				String bes = sc.next();
				Hastag ukaz = new Hastag(bes);

				akcije.add(ukaz);
				dokument.add(bes);
				porabaSum += ukaz.vrniPorabo();

			} else if(ukazC == '+') {
				int st = sc.nextInt();
				String bes = sc.next();				
				Plus ukaz = new Plus(st, bes);

				akcije.add(ukaz);
				dokument.add(st, bes);
				porabaSum += ukaz.vrniPorabo();

			} else if(ukazC == '-') {
				int st = sc.nextInt();
				Minus ukaz = new Minus(st);

				akcije.add(ukaz);
				dokument.remove(st);
				porabaSum += ukaz.vrniPorabo();

			} else if(ukazC == '<') {
				Ukazi ukaz = akcije.get(akcije.size()-1);
				
				if(ukaz instanceof Plus) {
					int ixd = ukaz.vrniIndeks();
					String bes = ukaz.vrniBesedo();
					Minus novi = new Minus(ixd, bes);
					
					porabaSum += novi.vrniPorabo();

					dokument.remove(ixd);

				} else if(ukaz instanceof Minus) {
					int ixd = ukaz.vrniIndeks();
					String bes = ukaz.vrniBesedo();
					Plus novi = new Plus(ixd, bes);
					
					porabaSum += novi.vrniPorabo();

					dokument.add(ixd, bes);
				}				
							
				izbrisani.add(ukaz);
				akcije.remove(akcije.size()-1);

			} else if(ukazC == '>') {
				Ukazi ukaz = izbrisani.get(izbrisani.size()-1);
				
				if(ukaz instanceof Plus) {
					dokument.add(ukaz.vrniIndeks(), ukaz.vrniBesedo());
					porabaSum += ukaz.vrniPorabo();

				} else if(ukaz instanceof Minus) {				
					dokument.remove(ukaz.vrniIndeks());
					porabaSum += ukaz.vrniPorabo();
				}								
			
				akcije.add(ukaz);
				izbrisani.remove(izbrisani.size()-1);

			} else
				break;


			
			printDokument();
	
			ukazC = sc.next().charAt(0);
		} while(ukazC != 'x');


    }



	static abstract class Ukazi { 
		protected int poraba;
		protected int ix;
		protected String beseda;

		protected abstract void izracunajPorabo();
		
		public int vrniPorabo() {
			return poraba;
		}
		
		public int vrniIndeks() {
			return ix;
		}

		public String vrniBesedo() {
			return beseda;
		}
	}

	
	static class Hastag extends Plus {
		public Hastag(String besedilo) {
			super(dokument.size(), besedilo);
		}
	}

	static class Plus extends Ukazi{
		public Plus(int indeks, String besedilo) {
			this.ix = indeks;
			this.beseda = besedilo;
			//add to akcije - maybe not
			izracunajPorabo();
		}

		protected void izracunajPorabo() {
			//System.out.println(dokument.size() + " in " + ix + " ter " + beseda);
			poraba = (2*(dokument.size()-ix) + beseda.length());
		}
	}

	static class Minus extends Ukazi{
		public Minus(int indeks) {
			this.ix = indeks;
			this.beseda = dokument.get(ix);
			izracunajPorabo();
			//System.out.println(ix + " in beseda: " + beseda + " ter poraba: " + poraba);
		}

		public Minus(int indeks, String besedilo) {
			this.ix = indeks;
			this.beseda = besedilo;
			izracunajPorabo();
		}

		protected void izracunajPorabo() {
			poraba = 3*(dokument.size()-ix-1) + 2*beseda.length();
		}
	}



	public static void printDokument() {
		System.out.print(porabaSum + " | ");

		String toStr  = "";
		if(dokument.size()>0) {
			toStr += dokument.get(0);
			for(int i = 1; i<dokument.size(); i++){
				toStr += "/" + dokument.get(i);
			}
		}
		System.out.println(toStr);
	}
}
