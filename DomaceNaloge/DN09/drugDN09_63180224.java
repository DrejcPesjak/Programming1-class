import java.util.Scanner;
import java.util.ArrayList;

public class drugDN09_63180224 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Ukazi> u = new ArrayList<Ukazi>();
		ArrayList<Ukazi> izbrisani = new ArrayList<Ukazi>();

		char ukaz = sc.next().charAt(0);
		int poraba = 0;

		do{

			ArrayList<String> str = new ArrayList<String>;

			if(ukaz == '#'){
				Ukaz z = Hastag(sc.next());
				poraba += z.izracunajPorabo(u.size());
				u.add(z);
				str.add(z.vrniIndeks(), z.vrniBesedilo());
			} else if(ukaz == '+') {
				Ukaz z = Plus(sc.nextInt(), sc.next());
				poraba += z.izracunajPorabo(u.size());
				u.add(z);
				str.add(z.vrniIndeks(), z.vrniBesedilo());
			} else if(ukaz == '-') {
				Ukaz z = Minus(sc.nextInt());
				poraba += z.izracunajPorabo(u.size());
				u.add(z);
				str.remove(z.vrniIndeks());
			} else if(ukaz == '<') {
				//Ukaz z = u.get(u.size()-1);
				odstranjeni.add(u.get(u.size()-1));
				u.remove(u.size()-1);
			} else if(ukaz == '>') {
				Ukaz z = odstranjeni.get(odstranjeni.size()-1);
				poraba += z.vrniPorabo();
				u.add(z);
				odstranjeni.remove(odstranjeni.size()-1);
			} else
				break;


			//string builder
			ArrayList<String> str = new ArrayList<String>;
			for(int i = 0; i<u.size(); i++) {
				Ukaz trenutni = u.get(i);
				if(trenutni instanceof Plus) {
					str.add(trenutni.vrniIndeks(), trenutni.vrniBesedilo());
				} else if(trenutni instanceof Minus) {
					str.remove(trenutni.vrniIndeks());
				}
			}

			System.out.print(u.get(0).vrniPorabo() + " | ");
			String toStr  = "";
			toStr += str.get(0);
			for(int i = 1; i<str.size(); i++){
				toStr += "/" + str.get(i);
			}
			System.out.println(toStr);

			//System.out.println(nov.toString());
			//print str brez prvega znaka (slash)
			ukaz = sc.next().charAt(0);
		} while(ukaz != 'x');


    }


	static abstract class Ukazi {
		protected int ix;
		protected int poraba;

		public int vrniPorabo() {
			return poraba;
		}

		protected abstract int izracunajPorabo(int stVrstic);

		public int vrniIndeks() {
			return ix;
		}
	}

	static class Hastag extends Plus {
		public Hastag(int besedilo, int stVrstic) {
			super(0, besedilo, stVrstic);
		}
	}

	static class Plus extends Ukazi{
		protected String str;

		public Plus(int indeks, int besedilo, int stVrstic){
			ix = indeks;
			str = besedilo;
			poraba = izracunajPorabo(stVrstic);
		}

		protected int izracunajPorabo(int stVrstic) {
			return (2*(stVrstic-ix) + str.length());
		}

		public String vrniBesedilo() {
			return str;
		}
	}

	static class Minus extends Ukazi{

		public Minus(int indeks, int stVrstic){
			ix = indeks;
			poraba = stVrstic(stVrstic);
		}

		protected int izracunajPorabo(int stVrstic) {
			return 3*(stVrstic-ix-1) + 2*str.length();
		}

	}

	/*static class Undo extends Ukazi {

		private static ArrayList<Ukazi> izbrisani;

		public Undo(Ukaz prejsni) {

		}

	}

	static class Redo extends Ukazi {

	}*/
}
