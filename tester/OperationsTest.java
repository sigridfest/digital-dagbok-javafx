package project.diary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


	public class OperationsTest {

	private Diary diary;
	private Operations operations;

	@BeforeEach
	public void OperationsTestSetUp() {
		diary = new Diary("01.01.2022", "1", "1", "tekst", "1");
		operations = new Operations();
	}
	@Test
	public void testOperations() {
		assertEquals(operations.calculateDay(diary),"3.6");
		diary = new Diary("01.01.2022","5","4","tekst","9");
		assertEquals(operations.calculateDay(diary), "6.6");
		diary = new Diary("01.01.2022","10","0","tekst","10");
		assertEquals(operations.calculateDay(diary),"10");
		diary = new Diary("01.01.2022","0","10","tekst","0");
		assertEquals(operations.calculateDay(diary), "0."); 
	}	

}
