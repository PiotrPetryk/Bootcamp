package pracownik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PracownikTest {
	
	private Pracownik p1;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Pracownik(100);
	}

	@Test
	void testUtworzUjemny() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			Pracownik p2 = new Pracownik(-100);
		});
		assertEquals("Ujemna wartość wynagrodzenia", e.getMessage());
	}
	
	@Test
	void testPracaUjemny() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			p1.pracuj(-8);
		});
		assertEquals("Ujemna ilość godzin", e.getMessage());
	}

	@Test
	void testPracaNorma() {
		p1.pracuj(5);
		assertEquals(500, p1.wyplata());
	}
	
	@Test
	void testPracaNormaKilka() {
		p1.pracuj(5);
		p1.pracuj(5);
		assertEquals(1000, p1.wyplata());
	}
	
	@Test
	void testWyplata() {
		p1.pracuj(5);
		p1.wyplata();
		assertEquals(0, p1.wyplata());
	}
	
	@Test
	void testPracaNadgodziny() {
		p1.pracuj(10);
		assertEquals(1200, p1.wyplata());
	}
	
	@Test
	void testPracaNadgodzinyKilka() {
		p1.pracuj(10);
		p1.pracuj(10);		
		assertEquals(2400, p1.wyplata());
	}
	
	@Test
	void testPracaownikZPremia() {
		PracownikZPremia pp = new PracownikZPremia(100);
		pp.pracuj(5);
		pp.pracuj(5);
		assertEquals(1000, pp.wyplata());
	}
	
	void testPracaownikZPremiaPremia() {
		PracownikZPremia pp = new PracownikZPremia(100);
		pp.pracuj(5);
		pp.pracuj(5);
		pp.premia(200);
		assertEquals(1200, pp.wyplata());
		assertEquals(0, pp.wyplata());
		
	}
	@Test
	void testPremiaUjemna() {
		PracownikZPremia pp = new PracownikZPremia(100);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			pp.premia(-100);
		});
		assertEquals("Ujemna wartość premii", e.getMessage());
	}
}
