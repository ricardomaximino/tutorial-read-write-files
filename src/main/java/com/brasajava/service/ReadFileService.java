package com.brasajava.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.brasajava.domain.entity.Person;

@Service
public class ReadFileService {
	
	public void readTheFileWithScanner() throws FileNotFoundException {
		System.out.println("Reading the file with the Scanner...");
		try(
				Scanner scanner = new Scanner(
						new File(
								this.getClass()
								.getClassLoader()
								.getResource("people.txt")
								.getFile()
								))){
			while(scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(", ");
				Person person = new Person();
				person.setId(data[0]);
				person.setName(data[1]);
				person.setFirstname(data[2]);
				person.setLastname(data[3]);
				String [] date = data[4].split("/");
				person.setBirthday(LocalDate.of(Integer.parseInt(date[2]), getMonth(date[1]), Integer.parseInt(date[0])));
				person.setActive(Boolean.parseBoolean(data[5]));
				System.out.println(person);
			}
			System.out.println("Finish reading the file with the Scanner...");
		}
	}
	
	public void readTheFile() throws IOException {
		System.out.println("Reading the file with BufferedReader...");
		try(
				BufferedReader reader = new BufferedReader(
						new FileReader(
								new File(
										this.getClass()
										.getClassLoader()
										.getResource("people.txt").getFile()
										)))){
			reader
				.lines()
				.map(String::toUpperCase)
				.map(line -> {
					String[] data = line.split(", ");
					Person person = new Person();
					person.setId(data[0]);
					person.setName(data[1]);
					person.setFirstname(data[2]);
					person.setLastname(data[3]);
					String [] date = data[4].split("/");
					person.setBirthday(LocalDate.of(Integer.parseInt(date[2]), getMonth(date[1]), Integer.parseInt(date[0])));
					person.setActive(Boolean.parseBoolean(data[5]));
					return person;
				})
				.forEach(System.out::println);
			System.out.println("Finish reading the file with BufferedReader...");
		}
		
	}

	private Month getMonth(String month) {
		switch (month) {
		case "1":
			return Month.JANUARY;
		case "2":
			return Month.FEBRUARY;
		case "3":
			return Month.MARCH;
		case "4":
			return Month.APRIL;
		case "5":
			return Month.MAY;
		case "6":
			return Month.JUNE;
		case "7":
			return Month.JULY;
		case "8":
			return Month.AUGUST;
		case "9":
			return Month.SEPTEMBER;
		case "10":
			return Month.OCTOBER;
		case "11":
			return Month.NOVEMBER;
		case "12":
			return Month.DECEMBER;
		default:
			throw new RuntimeException("The Month must be represented within 01-12");
		}
	}
}
