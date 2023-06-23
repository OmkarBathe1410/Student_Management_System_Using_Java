package complete_java_course_from_udemy.project.StudentManagementSystem;

public class Student {
	private String name;
	private String email;
	private int ID;
	private int age;
	private double GPA;
	
	public Student(String name, String email, int ID, int age, double GPA) {
		this.name = name;
		this.email = email;
		this.ID = ID;
		this.age = age;
		this.GPA = GPA;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + 
				"\nID: " + this.ID + 
				"\nEmail: " + this.email +
				"\nGPA: " + this.GPA + "\n";
	}
}
