package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted Row Count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		// defining the student id of the student to be deleted
		int studentId = 2;

		System.out.println("Deleting student with id: " + studentId);

		//calling the delete method to delete the student whose id is passed
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the primary key: id
		int studentID = 4;
		System.out.println("Getting student with id: " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		//change retrieved student's first name to "Elon" and likewise
		System.out.println("Updating student ... ");
		myStudent.setFirstName("Elon");
		myStudent.setLastName("Musk");
		myStudent.setEmail("elon@gmail.com");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> students = studentDAO.findByLastName("Cohen");

		//display the list of students
		for(Student tempStudent:students){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students in the database
		List<Student> students= studentDAO.findAll();

		//display the list of students
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new Student object...");
		Student tempStudent = new Student("Gauzam", "Malhotra", "gauzam@gmail.com");

		//save the student in the database
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent);

		//display the id of the student
		System.out.println("Student saved. Generated id: " + tempStudent.getId());

		//retrieve the student based on the id (primary key)
		System.out.println("Retrieving the Student with the given id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		//display the student
		//note: here the toString() of myStudent is implicitly invoked
		System.out.println("Retrieved the Student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//creating multiple students
		System.out.println("Creating student objects...");
		Student tempStudent1 = new Student("Sam", "Altman", "sam@gmail.com");
		Student tempStudent2 = new Student("Paul", "Graham", "paul@gmail.com");
		Student tempStudent3 = new Student("Alex", "Cohen", "alex@gmail.com");

		//saving the students to the database
		System.out.println("Saving student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved given student objects.");
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Gauzam", "Malhotra", "gauzam@gmail.com");

		//save the student object in the database
		System.out.println("Saving this student object in the database...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());
	}

}
