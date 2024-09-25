package project.diary;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class AppController {
	FileHandling file = new FileHandling();
	@FXML private TextField date, laugh, stress, sleep, text, search;
	@FXML private TextArea out, entry;
	@FXML private Button ent, search_button;
	
	public void onEnt() throws IOException {
		String date = this.date.getText();
		String laugh = this.laugh.getText();
		String text = this.text.getText();
		String stress = this.stress.getText();
		String sleep = this.sleep.getText();
		
		Diary Entry = new Diary(date,laugh,stress,text,sleep);
		
		if(!Entry.validateInput(date,laugh,stress,text,sleep)) {
			out.setText("Ugyldig input.");
		}
		else {
			if(!file.doesDayExist("entries", date)) {
				out.setText("Du hadde en " + Entry.getScore() + "/10 dag!");
				file.writeDayToFile(Entry, "entries");
			}
			else {
				out.setText("Du har allerede skrevet om " + Entry.getDate() + ". Søk på datoen i søkefeltet for å se hvordan dagen var.");
			}
		}
	}
	
	public void onSearch() throws IOException {
		String date = this.search.getText();
		entry.setText(file.findEntry(date, "entries"));
	}
}