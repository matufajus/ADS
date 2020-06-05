package main.exercise;
import java.util.ArrayList;
import java.util.List;

public class Calendars {
	
// Input:	two different schedules with times that are already used
//			and duration for a meeting
// Output:  times when meeting between given schedules is available

//  Input example:
//	private String[][] person1Schedule= {{"9:00", "10:30"},{"12:00", "13:00"},{"16:00", "18:00"}};
//	private String[][] person2Schedule= {{"10:00", "11:30"},{"12:30", "14:30"},{"14:30", "15:00"},{"16:00", "17:00"}};
//	private int duration = 30;
	
	public String[][] getAvailableTimeForMeeting(String[][] p1Schedule, String[][] p2Schedule, int meetingTime){
		String[][] mergedSchedule = mergeSchedules(p1Schedule, p2Schedule);
		String[][] availableTimes = new String[mergedSchedule.length][2];
		int j = 0;
		for (int i = 0; i < mergedSchedule.length-1; i++) {
			if ((getTotalMinutes(mergedSchedule[i+1][0])-getTotalMinutes(mergedSchedule[i][1])) >= meetingTime) {
				availableTimes[j][0] = mergedSchedule[i][1];
				availableTimes[j][1] = mergedSchedule[i+1][0];
				j++;
			}
		}
		return availableTimes;
	}

	private String[][] mergeSchedules(String[][] p1Schedule, String[][] p2Schedule) {
		//add them together sorted by starting time
		int totalTimes = p1Schedule.length+p2Schedule.length;
		String[][] combinedSchedules = new String[totalTimes][2];
		int i = 0, j = 0, k = 0;
		
		while(i < p1Schedule.length && j < p2Schedule.length) {
			if (compare(p1Schedule[i][0], p2Schedule[j][0]) <= 0) {
				combinedSchedules[k] = p1Schedule[i];
				i++;
			} else {
				combinedSchedules[k] = p2Schedule[j];
				j++;
			}
			k++;
		}
		while(i < p1Schedule.length){
			combinedSchedules[k] = p1Schedule[i];
			k++;
			i++;
		}
		while(j < p2Schedule.length){
			combinedSchedules[k] = p2Schedule[j];
			k++;
			j++;
		}
		//merge or remove overlapping times
		i = 0;
		while (i < combinedSchedules.length-1){
			if (compare(combinedSchedules[i][1], combinedSchedules[i+1][0]) > 0) {
				if (compare(combinedSchedules[i][1], combinedSchedules[i+1][1]) > 0) {
					//removing time
					combinedSchedules = removeTimeFromScheduleAt(combinedSchedules, i+1);
				}else {
					//merging two times by switching first end time and deleting second time
					combinedSchedules[i][1] = combinedSchedules[i+1][1];
					combinedSchedules = removeTimeFromScheduleAt(combinedSchedules, i+1);
				}
			} else {
				i++;
			}
		}
		return combinedSchedules;
	}
	
	private String[][] removeTimeFromScheduleAt(String[][] combinedSchedules, int index) {
		String[][] newSchedule = new String[combinedSchedules.length-1][2];
		for(int i = 0; i < newSchedule.length; i++) {
			if (i < index) {
				newSchedule[i] = combinedSchedules[i];
			}else {
				newSchedule[i] = combinedSchedules[i+1];
			}
			
		}
		return newSchedule;
	}

	private int compare(String time1, String time2) {
		int time1minutes = getTotalMinutes(time1);
		int time2minutes = getTotalMinutes(time2);		
		return time1minutes - time2minutes;		
	}
	
	private int getTotalMinutes(String time) {
		String hours = time.substring(0, 2);
		String minutes = time.substring(3, 5);
		int h = Integer.parseInt(hours);
		int m = Integer.parseInt(minutes);
		return h*60+m;
	}
	
	

}
