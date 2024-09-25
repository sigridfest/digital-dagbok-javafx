package project.diary;

import static org.junit.jupiter.api.Assertions.*;


import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileHandlingTest {
	
	private FileHandling fileHandling;
	private Diary diary;
	private String savedNewDay;
	
	@BeforeEach
	public void FileHandlingTestSetUp() {
		fileHandling = new FileHandling();
		diary = new Diary("01.01.2022","1","1","tekst","1");		
	}
	//Teste at man finner innlegg
	@Test
	public void testFindEntry() {
		String savedNewDay;
		try {
			savedNewDay=fileHandling.findEntry("01.01.2022","entries");
		} catch (IOException e) {
			fail("Finner ikke dagbok-innlegget");
			return;
		}
		assertEquals(savedNewDay,"tekst" + "\n" + "Score: 3.6" + ". ");
	}
	//Hva som skjer når man soeker opp ugyldig dato
	@Test
	public void testFindEntryInvalidDate() {
		try {
			savedNewDay = fileHandling.findEntry("01.01.22","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen er ugyldig");
		}
		assertEquals(savedNewDay,"Dato er ugyldig");	
		
		try {
			savedNewDay = fileHandling.findEntry("01.01.2000","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen er ugyldig");
		}
		assertEquals(savedNewDay, "Dato er ugyldig");	
		
		try {
			savedNewDay = fileHandling.findEntry("rbgds","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen er ugyldig");
		}
		assertEquals(savedNewDay, "Dato er ugyldig");	
		
		try {
			savedNewDay = fileHandling.findEntry("32.10.2024","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen er ugyldig");
		}
		assertEquals(savedNewDay, "Dato er ugyldig");	
		
		try {
			savedNewDay = fileHandling.findEntry("01.14.2024","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen er ugyldig");
		}
		assertEquals(savedNewDay, "Dato er ugyldig");	
	}
	//Soeke opp dato som ikke eksisterer
	@Test
	public void testFindEntryNotExistingDate() {
		try {
			savedNewDay = fileHandling.findEntry("01.01.2080","entries");
		} catch (IOException e) {
			fail("Skulle returnert at datoen ikke er skrevet om");
		}
		assertEquals(savedNewDay,"Du har ingen innlegg for denne dagen.");
	}
	
	
	@Test
	public void testInvalidDoesDayExist() {
		try {
			assertFalse(fileHandling.doesDayExist("entries","01.01.22"));
		} catch (IOException e) {
			fail("Skulle returnere false naar datoen ikke er gyldig");
		}
	}

	@Test
	public void testDoesDayExistNotExistingDate() {
		try {
			assertFalse(fileHandling.doesDayExist("entries","01.01.2050"));
		} catch (IOException e) {
			fail("Skulle returnert false siden det ikke finnes innlegg fra denne dagen");
		}
	}
	
	@Test 
	public void testValidDoesDayExist() {
		try {
			assertTrue(fileHandling.doesDayExist("entries","01.01.2022"));
		} catch (IOException e) {
			fail("Skulle returnert true");
		}
	}
	
	@Test
	public void testWrongFileName() {
		try {
			fileHandling.writeDayToFile(diary, "not-existing-file");
			savedNewDay = fileHandling.findEntry("01.01.2022", "not-existing-file");
		} catch (IOException e) {
			fail("Det skal gaa an aa skrive til og lese fra fil som ikke eksisterer");
			return;
		}
		assertEquals(savedNewDay,"tekst" + "\n" + "Score: 3.6" + ". ");
	}
	
	@Test
	public void testSavingToExistingFile() {
		try {
			fileHandling.writeDayToFile(diary, "entries");
			savedNewDay = fileHandling.findEntry("01.01.2022", "entries");
		} catch (IOException e) {
			fail("Det skal gaa an å skrive til og lese fra fil som eksisterer");
		}
		assertEquals(savedNewDay,"tekst" + "\n" + "Score: 3.6" + ". ");
	}

	@Test
	public void testGetFilePath() {
		try {
			assertEquals(fileHandling.getFilePath("entries"),new File(System.getProperty("user.home")+"\\" + "entries"));
		} catch (IOException e) {
			fail("getFilePath skulle vært lik som å finne filePathen manuelt");
		}
	}
	
}

