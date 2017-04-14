package modeler;

//Getting an error for adding classes to a schedule that i don't know how to fix

import java.util.*;

import javax.swing.JOptionPane;

public class Driver {
	static String[] yn= {"Yes", "No"};
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();
		List<FacultyMember> profs = new ArrayList<FacultyMember>();
		List<Course> courses = new ArrayList<Course>();

		String[] mainMenu = {"Quit", "Create", "Edit", "View"};
		String[] addMenu = {"Course", "Student", "Faculty"};
		String[] deleteMenu = {"Student", "Faculty"};
		String[] stuEdit = {"Delete Student", "Delete Course", "Add Course"};
		String[] profEdit = {"Delete Faculty Member", "Delete Course", "Add Course"};

		int choice1, choice2, choice3;
		do{
			choice1 = JOptionPane.showOptionDialog(null, "Main Menu", "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, mainMenu, "null");

			switch(choice1){

			case 0:
				break;

			//creating course/student/faculty	
			case 1:
				choice2 = JOptionPane.showOptionDialog(null, "Create", "Maker", 0, JOptionPane.QUESTION_MESSAGE, null, addMenu, "null");
				
				switch(choice2){
				case 0:
					addCourse(courses);
					break;
					
				case 1:
					addStudent(students, courses);
					break;
					
				case 2:
					addProf(profs, courses);
					break;
				}
				break;
				
			//editing
			case 2:
				choice2 = JOptionPane.showOptionDialog(null, "Editor", "Master Editor", 0, JOptionPane.QUESTION_MESSAGE, null, deleteMenu, "null");
				
				switch(choice2){
				case 0:
					choice3 = JOptionPane.showOptionDialog(null, "Are You Deleting a Person or a Course from their Schedule?", "Remover", 0, JOptionPane.QUESTION_MESSAGE, null, stuEdit, "null");
					
					switch(choice3){
					case 0:
						delStudent(students);
						break;
					
					case 1:
						delCourseS(students);
						break;
						
					case 2:
						addCourseS(students, courses);
						break;
					}
				break;
					
				case 1:
					choice3 = JOptionPane.showOptionDialog(null, "Are You Deleting a Person or a Course from their Schedule?", "Remover", 0, JOptionPane.QUESTION_MESSAGE, null, profEdit, "null");
					
					switch(choice3){
					case 0:
						delProf(profs);
						break;
					
					case 1:
						delCourseF(profs);
						break;
						
					case 2:
						addCourseF(profs, courses);
						break;
					}
					break;
				}
			//view people
			case 3:
				for(int i = 0; i <courses.size(); i++){
					JOptionPane.showMessageDialog(null, "COURSES OFFERED: " + courses.get(i));
				}
				for(int i = 0; i < students.size(); i++){
					JOptionPane.showMessageDialog(null, "STUDENT: " + students.get(i));
				}
				for(int i = 0; i < profs.size(); i++){
					JOptionPane.showMessageDialog(null, "FACULTY MEMBER: " + profs.get(i));
				}
				break;
			}
			
		}while(choice1 != 0);
	
	}
	
	public static List<Course> addCourse(List<Course> course){
		String id;
		String title;
		
		id = JOptionPane.showInputDialog("What is the course identifier (i.e. EE-101)");
		title = JOptionPane.showInputDialog("What is the course title");
		
		Course nCourse = new Course(id, title);
		
		course.add(nCourse);
		return course;
	}

	public static List<Student> addStudent(List<Student> students, List<Course> courses){
		String address;
		String name;
		int cin;
		int stNum = 0;
		String st = null, city = null, state = null, country = null;
		int hasClass;
		List<Course> schedule = new ArrayList<>();
		
		name = JOptionPane.showInputDialog("What is the student's name?");
		
		address = JOptionPane.showInputDialog("What is " + name + "'s address (e.g. 1234, Address Blvd., Los angeles, CA, USA (Enter with the commas like that))");
		
		String[] a = address.split(", ");
		for(int i = 0; i < a.length; i++){
			stNum = Integer.parseInt(a[0]);
			st = a[1];
			city = a[2];
			state = a[3];
			country = a[4];
		}
		
		cin = Integer.parseInt(JOptionPane.showInputDialog("What is " + name + "'s CIN?"));
		
		
		for(int i = 0; i < courses.size(); i++){
			hasClass = JOptionPane.showOptionDialog(null, "Do you have " + courses.get(i) + "?", "Schedule Builder", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			
			switch(hasClass){
			case 0:
				schedule.add(courses.get(i));
				break;
			case 1:
				break;
			}
			
		}
		
		Student stu1 = new Student(stNum, st, city, state, country, name, cin, schedule);
		
		students.add(stu1);
		return students;
	}

	public static List<FacultyMember> addProf(List<FacultyMember> profs, List<Course> courses){
		String address;
		String name;
		int id;
		int stNum = 0;
		String st = null, city = null, state = null, country = null;
		int hasClass;
		List<Course> schedule = new ArrayList<>();
		
		name = JOptionPane.showInputDialog("What is the faculty member's name?");
		
		address = JOptionPane.showInputDialog("What is " + name + "'s address (e.g. 1234, Address Blvd., Los angeles, CA, USA (Enter with the commas like that))");
		
		String[] a = address.split(", ");
		for(int i = 0; i < a.length; i++){
			stNum = Integer.parseInt(a[0]);
			st = a[1];
			city = a[2];
			state = a[3];
			country = a[4];
		}
		
		id = Integer.parseInt(JOptionPane.showInputDialog("What is " + name + "'s Employe ID Number?"));
		
		
		for(int i = 0; i < courses.size(); i++){
			hasClass = JOptionPane.showOptionDialog(null, "Does " + name + " teach " + courses.get(i) + "?", "Schedule Builder", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			
			switch(hasClass){
			case 0:
				schedule.add(courses.get(i));
				break;
			case 1:
				break;
			}
			
		}
		
		FacultyMember mem1 = new FacultyMember(stNum, st, city, state, country, name,id, schedule);
		
		profs.add(mem1);
		return profs;
	}

	public static List<Student> delStudent(List<Student> students){
		int remove;
		
		for(int i = 0; i < students.size(); i++){
			remove = JOptionPane.showOptionDialog(null, "DELETE " + students.get(i) + "?", "Student Deletion", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			
			switch(remove){
			case 0:
				students.remove(i);
				break;
			case 1:
				break;
			}
		}
		
		return students;
	}
	
	public static List<Student> delCourseS(List<Student> students){
		int choice;
		int remove;
		Student stu;
		
		for(int i = 0; i < students.size(); i++){
			choice = JOptionPane.showOptionDialog(null, "Would you like to edit the schedule of " + students.get(i), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			stu = students.get(i);
			
			switch(choice){
			case 0:
				for(int j = 0; j < stu.getSchedule().size(); j++){
					remove = JOptionPane.showOptionDialog(null, j + "DELETE " + stu.getSchedule().get(j) + " from " + stu.getName() + "'s Schedule?", "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
				
					switch(remove){
					case 0:
						stu.getSchedule().remove(j);
						break;
					case 1:
						break;
					}
					students.remove(i);
					students.add(stu);
				}
				break;
			case 1:
				break;
			}
		}
		
		return students;
	}
	
	public static List<Student> addCourseS(List<Student> students, List<Course> courses){
		int choice;
		int add;
		Student stu;
		
		for(int i = 0; i < students.size(); i++){
			choice = JOptionPane.showOptionDialog(null, "Would you like to edit the schedule of " + students.get(i), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			stu = students.get(i);
			
			switch(choice){
			case 0:
				for(int j = 0; j < courses.size(); j++){
					if(!(stu.getSchedule().contains(courses.get(j)))){
						add = JOptionPane.showOptionDialog(null, "Add " + courses.get(j), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
						
						switch(add){
						case 0:
							stu.getSchedule().add(courses.get(j));
							break;
						case 1:
							break;
						}
					}
				}
				break;
			case 1:
				break;
			}
		}
		
		return students;
	}

	public static List<FacultyMember> delProf(List<FacultyMember> profs){
		int remove;
		
		for(int i = 0; i < profs.size(); i++){
			remove = JOptionPane.showOptionDialog(null, "DELETE " + profs.get(i) + "?", "Faculty Deletion", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			
			switch(remove){
			case 0:
				profs.remove(i);
				break;
			case 1:
				break;
			}
		}
		
		return profs;
	}

	public static List<FacultyMember> delCourseF(List<FacultyMember> profs){
		int choice;
		int remove;
		FacultyMember prof;
		
		for(int i = 0; i < profs.size(); i++){
			choice = JOptionPane.showOptionDialog(null, "Would you like to edit the schedule of " + profs.get(i), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			prof = profs.get(i);
			
			switch(choice){
			case 0:
				for(int j = 0; j < prof.getSchedule().size(); j++){
					remove = JOptionPane.showOptionDialog(null, j + "DELETE " + prof.getSchedule().get(j) + " from " + prof.getName() + "'s Schedule?", "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
				
					switch(remove){
					case 0:
						prof.getSchedule().remove(j);
						break;
					case 1:
						break;
					}
					profs.remove(i);
					profs.add(prof);
				}
				break;
			case 1:
				break;
			}
		}
		
		return profs;
	}

	public static List<FacultyMember> addCourseF(List<FacultyMember> profs, List<Course> courses){
		int choice;
		int add;
		FacultyMember prof;
		
		for(int i = 0; i < profs.size(); i++){
			choice = JOptionPane.showOptionDialog(null, "Would you like to edit the schedule of " + profs.get(i), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
			prof = profs.get(i);
			
			switch(choice){
			case 0:
				for(int j = 0; j < courses.size(); j++){
					if(!(prof.getSchedule().contains(courses.get(j)))){
						add = JOptionPane.showOptionDialog(null, "Add " + courses.get(j), "Schedule Editor", 0, JOptionPane.QUESTION_MESSAGE, null, yn, "null");
						
						switch(add){
						case 0:
							prof.getSchedule().add(courses.get(j));
							break;
						case 1:
							break;
						}
					}
				}
				break;
			case 1:
				break;
			}
		}
		
		return profs;
	}
}
