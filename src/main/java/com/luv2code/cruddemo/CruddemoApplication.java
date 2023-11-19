package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("gauzam", "malhotra", "gauzam@gmail.com");

		//save the student object in the database
		System.out.println("Saving this student object in the database...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());
	}

}
