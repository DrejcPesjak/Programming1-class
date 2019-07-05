import java.util.Scanner;
import java.util.ArrayList;

public class cheapDN09_63180224 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Ukazi nov = new Ukazi();
		char ukaz = sc.next().charAt(0);

		do{
			if(ukaz == '#'){
				nov.hastag(sc.next());
			} else if(ukaz == '+') {
				nov.plus(sc.nextInt(), sc.next());
			} else if(ukaz == '-') {
				nov.minus(sc.nextInt());
			} else if(ukaz == '<') {

			} else if(ukaz == '>') {

			} else
				break;

			System.out.print(nov.vrniPorabo() + " | ");
			System.out.println(nov.toString());
			ukaz = sc.next().charAt(0);
		} while(ukaz != 'x');
	}

	static class Ukazi {
		private ArrayList<String> dokument;
		private ArrayList<String> odstranjeni;
		private int poraba;

		public Ukazi() {
			dokument = new ArrayList<String>();
			odstranjeni = new ArrayList<String>();
			poraba = 0;
		}

		public void hastag(String abc) {
			dokument.add(abc);
			poraba += abc.length();
		}

		public void plus(int x, String abc) {
			poraba += (dokument.size()-x)*2 + abc.length();
			dokument.add(x, abc);
		}

		public void minus(int x) {
			poraba += dokument.get(x).length() *2 + (dokument.size()-x-1)*3;
			dokument.remove(x);
		}

		public void undo() {
			odstranjeni.add(dokument.get(dokument.size()-1));
			dokument.remove(dokument.size()-1);
		}

		public void redo() {
			dokument.add(odstranjeni.get(odstranjeni.size()-1));
			odstranjeni.remove(odstranjeni.size()-1);
		}


		public ArrayList<String> vrniDokument(){
			return dokument;
		}
		public int vrniPorabo() {
			return poraba;
		}


		public String toString() {
			String toStr  = "";

			toStr += dokument.get(0);
			for(int i = 1; i<dokument.size(); i++){
				toStr += "/" + dokument.get(i);
			}
			return toStr;
		}
	}
}
