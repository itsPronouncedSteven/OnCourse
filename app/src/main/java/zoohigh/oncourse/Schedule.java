package zoohigh.oncourse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Schedule {
	
	ArrayList<Semester> semesterList;
	
	Set<Course> recommendedSet = new HashSet<Course>();
	ArrayList<Course>recommendedList = new ArrayList<Course>();
	ArrayList<Course>potentialStudentList = new ArrayList<Course>();
	
	Schedule(){
		
		semesterList = new ArrayList<Semester>();
	}

    //made void into array<course> to just see if it works on the listview of recommended courses
	void BuildSchedule(ArrayList<Course> catalog, Student student){
			potentialStudentList = student.studentCourseList;
			//if the recommendedList is empty build the list, then build the initial semester
			for(int index = 0;index < 1;index++)
			{
				for(OFFERED current_semester: OFFERED.values())
				{
					if(recommendedList.isEmpty())
					{
						//System.out.println(current_semester.toString());
						buildRecommendedList(catalog,potentialStudentList);
						//printRecommendedList();
		
						Semester semester = new Semester(student.starting_semester.toString() + " Semester",student.unit_cap);
						
						//iterate through recommendedList and if the course matches with the starting semester FALL/SPRING enum, then add it to the course list of that semester
						//Then check if the units do not go over the unit cap which is 12 for this example
						for(int i = 0;i < recommendedList.size();i++)
						{
							if(recommendedList.get(i).offered.contains(student.starting_semester) && semester.getCurrentUnits() != semester.getUnitCap() && student.starting_semester == current_semester)
							{
								//System.out.println(recommendedList.get(i).getName());
								semester.semesterCourseList.add(recommendedList.get(i));
								semester.incrementCurrentUnits(recommendedList.get(i).getCredit_hours());	//adds credit hours to current_units based on the course you are adding
								potentialStudentList.add(recommendedList.get(i));
							}
						}
						
						semesterList.add(semester);
						//System.out.println(semester.current_units);
						//printPotentialStudentList();
					}
					else
					{
						//System.out.println("=================");
						//System.out.println(current_semester.toString());
						buildRecommendedList(catalog,potentialStudentList);
						//printRecommendedList();
						
						Semester semester = new Semester(current_semester.toString() + " Semester",student.unit_cap);
						
						for(int i = 0;i < recommendedList.size();i++)
						{
							if(recommendedList.get(i).offered.contains(current_semester) && semester.getCurrentUnits() != semester.getUnitCap() && !potentialStudentList.contains(recommendedList.get(i)))
							{
								semester.semesterCourseList.add(recommendedList.get(i));
								semester.incrementCurrentUnits(recommendedList.get(i).getCredit_hours());
								
								if(!potentialStudentList.contains(recommendedList.get(i)))
								{	
									potentialStudentList.add(recommendedList.get(i));
								}
							}
						}
						
						semesterList.add(semester);
						//System.out.println(semester.current_units);
						//System.out.println("=================");
						//printPotentialStudentList();
						
					}
				}
	
			}
	}
	
	void buildRecommendedList(ArrayList<Course> catalog, ArrayList<Course> courseList)
	{
		recommendedList.clear();
		//iterate through the list of catalog classes
		for(int i = 0;i < catalog.size();i++)
		{
			//System.out.println("Course " + catalog.get(i).getName());
			//iterate through each prereq in each course
			for(int j = 0;j < catalog.get(i).prereqs.size();j++)
			{
				//if the prereq is contained in the student course list, continue
				if(courseList.contains(catalog.get(i).prereqs.get(j)))
				{
					//System.out.println("	"+ catalog.get(i).prereqs.get(j).getName());

					//if the student course list does not contain the catalog course, continue
					if(!courseList.contains(catalog.get(i)))
					{
						recommendedSet.add(catalog.get(i));
					}

				}
			}
		}
		
		recommendedList.addAll(recommendedSet);
		
	}
	
	
	void printSchedule()
	{
		System.out.println("PRINTING SCHEDULE");
		for(int i = 0;i < semesterList.size();i++){
			
			System.out.println(semesterList.get(i).getName());
			
			for(int j = 0;j < semesterList.get(i).semesterCourseList.size();j++)
			{
				System.out.println("	" + semesterList.get(i).semesterCourseList.get(j).getName());
			}
		}
	}
	
	void printRecommendedList()
	{
		System.out.println("");
		System.out.println("RECOMMENDED");
 
		//System.out.println(recommendedList.size());

		for(int i = 0;i < recommendedSet.size();i++)
		{	
			System.out.println(recommendedList.get(i).getName());
			//System.out.println(recommendedList.get(i).semester);

		}
	}
	
	void printPotentialStudentList()
	{
		System.out.println("POTENTIAL STUDENT LIST");
		for(int i = 0;i < potentialStudentList.size();i++)
		{	
			System.out.println(potentialStudentList.get(i).getName());
			//System.out.println(recommendedList.get(i).semester);

		}
		
	}

}
