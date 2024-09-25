package project.diary;

import java.io.File;
import java.io.IOException;

public interface FileInterface {
	public void writeDayToFile(Diary day, String filename) throws IOException;
	public File getFilePath(String filename) throws IOException;
	public String findEntry(String date, String filename) throws IOException;
}
