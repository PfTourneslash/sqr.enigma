package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() { //retourne la position
        return position;
    }

    public void setPosition(int posn) { //d�finie une position
        position = posn;
    }
    
	public static Rotor rotorFactory(String str, String notches){ // Retourne un rotor en fonction du code d'entr�
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]); 	//ici on cr�er notre cipher (qui lie l'entr� � la sortie)
		}
		s = notches.trim().replace(" and ", "").toCharArray(); //correspond a la transition de lettre qui d�clenchera un mouvent du second ou troisieme rotor
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	Rotor(int[] c, int notch1, int notch2) { //cr�e un rotor a deux notch avec un cipher
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) { //cr�er un rotor avec un seul notch et son cipher
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) { //traduit la position de d�part du rotor � celle d'arriv�e
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) { //traduit la position d'arriv� � celle de d�part
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    public void advance() { //fait tourner le rotor de 1
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() { //renvoie true si on est sur une notch
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) { //convertie les chiffres en lettres
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) { //convertie les lettres en chiffres (position a partir de A)
        return c - 'A';
    }
    
	private void createBCipher() { //cr�e le cipher inverse
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
