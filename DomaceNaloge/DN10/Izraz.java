import java.util.*;

public class Izraz{
	public String niz;

public Izraz(String niz){
	this.niz = niz;
}

public static Izraz zgradi(String niz){


/*StringBuilder sb = new StringBuilder(niz);
tabela.add(niz);
int dolzinaNiza = niz.length();
int i = 0;
char u = niz.charAt(i);
char m = niz.charAt(dolzinaNiza -1 -i);

do{
	deleteCharAt(i)

	i += 1;
}while((u == '(') && (m == ')'));
*/

niz = niz.replace("(","");
niz = niz.replace(")","");

Izraz niz1 = new Izraz(niz);


return niz1;

}


public int steviloOperatorjev(){
int x = 0;
for(int i = 0; i < niz.length(); i++){
char c = niz.charAt(i);
if(c == '+' || c == '-' || c == '*' || c == '/'){
	x += 1;
}
}

return x;
}

public String postfiksno(){
char[] tabela = niz.toCharArray();
for (int i = 0; i < tabela.length; i++){
	char c = tabela[i];
	if(Character.isDigit(c) && i != 0){
		tabela[i] = tabela[i-1];
		tabela[i-1] = c;
	}
}
String noviNiz = new String(tabela);


return noviNiz;
}

	public int vrednost(){
		String stevilo = "";
		String operator = "";
		int vrednost = 0;
		for (int i = 0; i < niz.length(); i++){
			char c = niz.charAt(i);

			if(Character.isDigit(c)){
				stevilo += c;
			}
			
			if(!Character.isDigit(c) || i == niz.length()-1){
				int parsed = Integer.parseInt(stevilo);
				if(operator == ""){
					vrednost = parsed;
				} else {
					if(operator.equals("+")) {
						vrednost += parsed;
					} else if (operator.equals("-")){
						vrednost -= parsed;
					} else if (operator.equals("*")){
						vrednost = vrednost * parsed;
					} else if (operator.equals("/")){
						vrednost = vrednost / parsed;
					}
				}
				stevilo = "";
				operator = ""+c;
			}
		}
		return vrednost;
	}


}
