package project.diary;

public class Diary {
	private  String date;
	private  String laugh;
	private  String stress;
	private  String text;
	private  String sleep;
	private String score; 
	private boolean inputValid;
	public Diary(String date, String laugh, String stress, String text, String sleep) {
		if(validateInput(date, laugh, stress, text, sleep)) {
			this.date=date;
			this.laugh=laugh;
			this.stress=stress;
			this.text=text;
			this.sleep=sleep;
			Operations operations = new Operations();
			this.score=operations.calculateDay(this);
			}
	}
	public Diary(String date) {
		if (validateDate(date)) {
			inputValid=true;
		}
		else {
			inputValid=false;
		}
	}
	public boolean getInputValid() {
		return inputValid;
	}
	public boolean validateInput(String date, String laugh, String stress, String text, String sleep) {
		if (validateDate(date) && validateLaugh(laugh) && validateSleep(sleep) && validateStress(stress) && validateText(text)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getScore() {
		return score;
	}
	public String getStress() {
		return stress;
	}
	public String getSleep() {
		return sleep;
	}
	public String getText() {
		return text;
	}
	public String getDate() {
		return date;
	}
	public String getLaugh() {
		return this.laugh;
	}
	public  boolean validateLaugh(String laugh) {
		if (!laugh.matches("[0-9]+")) {
			return false;
		}
		else {
			int laughint = Integer.parseInt(laugh);
			if (laughint>=0 && laughint<=10) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public boolean validateStress(String stress) {
		if (!stress.matches("[0-9]+")) {
			return false;
		}
		else {
			int stressint = Integer.parseInt(stress);
			if (stressint>=0 && stressint<=10) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public  boolean validateSleep(String sleep) {
		if (!sleep.matches("[0-9]+")) {
			return false;
		}
		else {
			int sleepint = Integer.parseInt(sleep);
			if (sleepint>=0 && sleepint<=10) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	private boolean validateCombo(int day1, int day2, int month1, int month2) {
		if (month1==0 && (month2==1 || month2==3 || month2==5 || month2==7 || month2==8)) {
			if (day1==0 || day1==1 || day1==2) {
				return true;
			}
			else if(day1==3 && day2<=1) {
				return true;
			}	
		}
		else if (month1==1 && (month2==0 || month2==2)) {
			if (day1==0 || day1==1 || day1==2) {
				return true;
			}
			else if(day1==3 && day2<=1) {
				return true;
			}
		}	
		else if (month1==0 && (month2==4 || month2==6 || month2==9)) {
			if (day1==0 ||  day1==1 || day1==2) {
				return true;
			}
			else if(day1==3 && day2==0) {
				return true;
			}	
		}
		else if (month1==1 && month2==1) {
			if (day1==0 || day1==1 || day1==2) {
				return true;
			}
			else if(day1==3 && day2==0) {
				return true;
			}	
		}
		else if (month1==0 && month2==2) {
			if (day1==0 || day1==1 || day1==2)	{
				return true;
			}
		}
		return false;
	}		
	public boolean validateDate(String date) {
		if (date.length()==10) {
			int day1=Integer.parseInt(date.substring(0,1));
			int day2=Integer.parseInt(date.substring(1,2));
			int month1=Integer.parseInt(date.substring(3,4));
			int month2=Integer.parseInt(date.substring(4,5));
			int year=Integer.parseInt(date.substring(6));
			if (date.charAt(2)=='.' && date.charAt(5)=='.') {
				if (day1>=0 && day1<=3 && day2>=0 && day2<=9) {
					if ((month1==0 && month2<=9) || (month1==1 && month2<=2)) {
						if (year>2020 && year<3000) {
							if (validateCombo(day1,day2,month1,month2)==true) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	public  boolean validateText(String text) {
		if(text != null && !text.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		String line = getDate() + ". Score: " + getScore() + ". " + getText();
		return line;
	}
}
