package complete_java_course_from_udemy.project.StudentManagementSystem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
		boolean shouldRun = true;
		while(shouldRun) {
			System.out.println("Enter a command (add, search, sort, view, exit): ");
			String command = sc.nextLine();
			
			switch(command) {
				case "add":
					addStudent(sc);
					break;
				case "search":
					searchStudent(sc);
					break;
				case "sort":
					sortStudents(sc);
					break;
				case "view":
					viewStudents();
					break;
				case "exit":
					shouldRun = false;
					break;
				default:
					System.out.println("Invalid command!");
					break;
			}
		} 
	}
	
	private static void addStudent(Scanner input) {
		System.out.println("Enter the student name: ");
		String name = input.nextLine();
		
		System.out.println("Enter the student ID: ");
		int ID = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the student email: ");
		String email = input.nextLine();
		
		while(!isValidEmail(email)) {
			System.out.println("Wrong email!\nEnter the valid student email: ");
			email = input.nextLine();
		}
		
		System.out.println("Enter the student age: ");
		int age = input.nextInt();
		
		System.out.println("Enter the student GPA: ");
		double GPA = input.nextDouble();
		input.nextLine();
		
		Student newStudent = new Student(name, email, ID, age, GPA);
		students.add(newStudent);
		
		System.out.println("Student added successfully!");
	}
	
	private static boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
	
	private static void searchStudent(Scanner input) {
		System.out.println("Enter the name of the student: ");
		String name = input.nextLine();
		
		students.forEach(student -> {
			if(student.getName() == name) {
				System.out.println(student);
			}
		});
	}
	
	private static void sortStudents(Scanner input) {
		System.out.println("Enter a field to sort by (name, ID, email, or GPA): ");
		String field = input.nextLine().toLowerCase();
		
		Collections.sort(students, new StudentComparator(field));
		
		students.forEach(student -> System.out.println(student));
	}
	
	private static void viewStudents() {
		students.forEach(student -> System.out.println(student));
	}
  
}


/*
 * Name: John Smith
ID: 12345
Email: john@gmail.com
GPA: 7.89

Name: Jane Doe
ID: 6789
Email: jane@hotmail.com
GPA: 8.95

Name: Alex Johnson
ID: 9012
Email: alex@gmail.com
GPA: 9.79
* */
