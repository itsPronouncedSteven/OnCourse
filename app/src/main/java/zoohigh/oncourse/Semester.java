package zoohigh.oncourse;
import java.util.ArrayList;

public class Semester {
		
		ArrayList<Course> semesterCourseList;
		OFFERED semester;
		String name;
		int unit_cap;
		int current_units = 0;
		
		Semester(){

			semesterCourseList =  new ArrayList<Course>();
		}
		
		Semester(String Name,int Unit_cap){

			semesterCourseList =  new ArrayList<Course>();
			unit_cap = Unit_cap;
			name = Name;
		}
		
		void incrementCurrentUnits(int inc)
		{
			current_units = current_units + inc;
		}
		
		int getCurrentUnits()
		{
			return current_units;
		}
		
		void setName(String Name)
		{
			name = Name;
		}
		
		String getName()
		{
			return name;
		}
		
		void setUnitCap(int cap)
		{
			unit_cap = cap;
		}
		
		int getUnitCap()
		{
			return unit_cap;
		}
		

		

}
