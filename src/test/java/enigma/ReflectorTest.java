package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {
	int[] c = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	Reflector ref = new Reflector(c);
	@Test
	public void convertForward_0_0() {
		int expected= 0;
		int actual = ref.convertForward(0);
		assertEquals(expected,actual);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void convertBackward_0_error() {
		int actual = ref.convertBackward(0);
	}

}
