package project.diary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DiaryTest {
private Diary diary;
	
	@BeforeEach
	public void diaryTestSetUp() {
		diary = new Diary("01.01.2022", "1", "1", "tekst", "1");
	}
	
	@Test
	public void testValidScores() {
		assertTrue(diary.validateLaugh("1"));
		assertTrue(diary.validateSleep("1"));
		assertTrue(diary.validateStress("1"));
	}
	
	@Test
	public void testInvalidLaugh() {
		assertFalse(diary.validateLaugh("11"));
		assertFalse(diary.validateLaugh("-1"));
		assertFalse(diary.validateLaugh("g"));
		assertFalse(diary.validateLaugh("."));
	}
	@Test
	public void testInvalidSleep() {
		assertFalse(diary.validateSleep("11"));
		assertFalse(diary.validateSleep("-1"));
		assertFalse(diary.validateLaugh("g"));
		assertFalse(diary.validateLaugh("."));
	}
		
	@Test
	public void testInvalidStress() {
		assertFalse(diary.validateStress("11"));
		assertFalse(diary.validateStress("-1"));
		assertFalse(diary.validateLaugh("g"));
		assertFalse(diary.validateLaugh("."));
	}
	
	@Test
	public void testInputValid() {
		assertTrue(diary.validateInput("01.01.2022", "1", "1", "tekst", "1"));
		assertTrue(diary.validateInput("31.05.2022", "6", "5", "tekst", "4"));
		assertTrue(diary.validateInput("20.07.2022", "1", "2", "tekst", "3"));
		assertTrue(diary.validateInput("01.01.2022", "1", "1", "Hei", "1"));		
	}
	
	@Test
	public void testInputInvalidDate() {
		assertFalse(diary.validateInput("32.01.2022", "1", "1", "tekst", "1"));
		assertFalse(diary.validateInput("01.13.2022", "1", "1", "tekst", "1"));
		assertFalse(diary.validateInput("01.01.2012", "1", "1", "tekst", "1"));
	}	
		
	@Test 
	public void testInputInvalid() {
		assertFalse(diary.validateInput("01.01.2022", "-1", "1", "tekst", "1"));
		assertFalse(diary.validateInput("01.01.2022", "1", "-1", "tekst", "1"));
		assertFalse(diary.validateInput("01.01.2022", "1", "1", "tekst", "-1"));
		assertFalse(diary.validateInput("01.01.2022", "11", "1", "tekst", "1"));
		assertFalse(diary.validateInput("01.01.2022", "1", "11", "tekst", "1"));
		assertFalse(diary.validateInput("01.01.2022", "1", "1", "tekst", "11"));
	}
	
	@Test
	public void testInvalidDate() {
		assertFalse(diary.validateDate("30.02.2022"));
		assertFalse(diary.validateDate("30.13.2022"));
		assertFalse(diary.validateDate("30.02.2012"));
	}
	
	@Test
	public void testValidText() {
		assertTrue(diary.validateText("Hadde en super dag!"));
		assertTrue(diary.validateText("..."));
		assertTrue(diary.validateText("OK"));
	}	
	
	@Test
	public void testInvalidText() {
		assertFalse(diary.validateText(""));
		assertFalse(diary.validateText(null));
	}
}