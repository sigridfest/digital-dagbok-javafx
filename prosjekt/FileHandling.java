package project.diary;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandling implements FileInterface{
	public void writeDayToFile(Diary day, String filename) throws IOException{
		try{
			PrintWriter writer = new PrintWriter(new FileWriter(getFilePath(filename), true), true);
			writer.println(day);
			writer.close();
		} catch (IOException e) {} 
	} 	
	
	public boolean doesDayExist(String filename, String date) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(getFilePath(filename)));
		try {
			for(String line = br.readLine(); line != null;line = br.readLine()){
				if(line.contains(date)){
					br.close();
					return true;
					}	
			}
		}
		catch(IOException e) {		}
		br.close();
		return false;
	}
	public String findEntry(String date, String filename) throws IOException {
		Diary input = new Diary(date);
		BufferedReader br = new BufferedReader(new FileReader(getFilePath(filename)));
		try {
			if(input.getInputValid()){
				for(String line = br.readLine(); line != null;line = br.readLine()) {
					if(line.contains(date)){
						br.close();
						return line.substring(24) + "\n" + line.substring(12,24);
					}
				}
				br.close();
				return "Du har ingen innlegg for denne dagen.";
			}
            
       } catch (IOException e) {}
		br.close();
   	 	return "Dato er ugyldig";
	}
	
	public File getFilePath(String filename) throws IOException {
		File file = new File(System.getProperty("user.home") + "\\" + filename );
		try {
			file.createNewFile();
			return file;
		}
		catch (IOException e){}
		return file;
        }
	}