package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;
	
	public static Reflector reflectorFactory(String str){ //configure le cipher et renvoi un reflector configurer avec ce cipher
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){ //surcharge du constructeur en paramettrant la reflexion
		super(r,0);
		reflection = r;
	}
        
    public int convertForward(int p) { //convertie l'entrée en sortie
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) { //Rejète une erreur car ne doit jamais arrivé
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
