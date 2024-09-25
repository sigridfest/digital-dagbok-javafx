package project.diary;

public class Operations {
	public Operations() {}
	public String calculateDay(Diary day) {
		int d_laugh=Integer.parseInt(day.getLaugh());
		int d_stress=Integer.parseInt(day.getStress());
		int d_sleep=Integer.parseInt(day.getSleep());
		double gjennomsnitt=((double)d_laugh+(10-d_stress)+d_sleep)/3;
		if (gjennomsnitt==10.0) {
			String score = (Double.toString(gjennomsnitt)).substring(0,2);
			return score;
			}
		String score = (Double.toString(gjennomsnitt)).substring(0,3);
		return score;
	}
}