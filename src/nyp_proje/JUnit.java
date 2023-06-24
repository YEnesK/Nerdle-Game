package nyp_proje;

import junit.framework.TestCase;


public class JUnit extends TestCase{
	
	private String denklem;
	
	protected void setUp() {
	}
	
	public void testGenerateEquation( ) {
		int beklenen;
		String sonuc = Denklem.generateEquation();
		if( (sonuc.length()==7) || (sonuc.length()==8) || (sonuc.length()==9)) {
			beklenen = 1;
		}else {
			beklenen=0;
		}
		assertEquals(1,beklenen);
	}
	
	
	public void testIsFirstCharacterOperator( ) {
		Denklem dnk= new Denklem();
		String denklem = Denklem.generateEquation();
		
		assertFalse(dnk.isOperator(denklem.charAt(0)));
	}
	
	public void testIsLastCharacterOperator( ) {
		Denklem dnk= new Denklem();
		String denklem = Denklem.generateEquation();
		
		assertFalse(dnk.isOperator(denklem.charAt(denklem.length()-1)));
	}
	
	public void testContainsEqual( ) {
		Denklem dnk= new Denklem();
		String denklem = Denklem.generateEquation();
		
		boolean control = false;
		for(int i=0 ; i<denklem.length() ; i++) {
			if(denklem.charAt(i)=='=')
				control = true;
		}
		assertTrue(control);
	}
	
	

}
