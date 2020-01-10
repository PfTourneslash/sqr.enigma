package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
	int[] c = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	Rotor rotor = new Rotor(c,1);
	
	
	
	@Test
	public void advance_0_1(){
		int expected = 1;
		rotor.setPosition(0);
		rotor.advance();
		int actual=rotor.getPosition();
		
		assertEquals(expected,actual);
	}
	@Test
	public void convertBackward_0_0() {
		int expected = 0;
		int actual = rotor.convertBackward(0);
		assertEquals(expected,actual);
	}
	
}

