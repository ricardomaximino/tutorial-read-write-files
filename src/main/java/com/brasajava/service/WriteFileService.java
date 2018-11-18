package com.brasajava.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Formatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brasajava.domain.entity.Person;

@Service
public class WriteFileService {
	private final String [] fistnames = {"Jose", "Maria", "Jacó", "Samantha", "Renan", "Brian", "Miguel Angel", "Pablo Montero", "Elisa Regina"};
	private final String [] lastnames = {"Fontana Perez", "Tamari Noguera", "Monte da Silva", "Martinez Novas", "Eros Calandra", "Ramazote Valente", "Santos Rodrigues"};
	private final String [] dias = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
	private final String [] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private final String [] years = {"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","1981","1982","1983","1984","1985","1986","1987","1988","1989","1980","1971","1972","1973","1974","1975","1976","1977","1978","1979","1970"};
	
	public void writeOnTheFile() throws IOException {
		System.out.println("Writing the File with PrintWriter...");
		try(
				PrintWriter writer = new PrintWriter(
						new FileWriter(
								new File(
										this
										.getClass()
										.getClassLoader()
										.getResource("people.txt")
										.getFile())
								,true)
						)){
			writer.println(parsePersonTowriteOnTheFile(createPerson()));
		}
	}
	
	public void writeOnTheFileWithFormater() throws IOException {
		System.out.println("Writing the File Formatter...");
		try(
				Formatter writer = new Formatter(
						new FileWriter(
								new File(
										this
										.getClass()
										.getClassLoader()
										.getResource("people.txt")
										.getFile())
								,true)
						)){
			String[] data = parsePersonToArrayToWriteOnTheFile(createPerson());
			writer.format("%s, %s, %s, %s, %s, %s", data[0],data[1],data[2],data[3],data[4],data[5]);
		}
	}
	private String parsePersonTowriteOnTheFile(Person person) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(person.getId())
		.append(", ")
		.append(person.getName())
		.append(", ")
		.append(person.getFirstname())
		.append(", ")
		.append(person.getLastname())
		.append(", ")
		.append(String.valueOf(person.getBirthday().getDayOfMonth()))
		.append("/")
		.append(String.valueOf(person.getBirthday().getMonthValue()))
		.append("/")
		.append(String.valueOf(person.getBirthday().getYear()))
		.append(", ")
		.append(String.valueOf(person.isActive()));
		return stringBuilder.toString();
	}
	
	private String[] parsePersonToArrayToWriteOnTheFile(Person person) {
		String date = person.getBirthday().getDayOfMonth() + "/" + person.getBirthday().getMonthValue() + "/" + person.getBirthday().getYear();
		return new String[] {person.getId(),person.getName(),person.getFirstname(),person.getLastname(),date,String.valueOf(person.isActive())};
	}
	
	
	private Person createPerson() {
		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		person.setActive(System.currentTimeMillis()%2 == 0);
		person.setFirstname(getRandomly(fistnames));
		person.setLastname(getRandomly(lastnames));
		person.setName(person.getFirstname() + " " + person.getLastname());
		person.setBirthday(LocalDate.of(Integer.parseInt(getRandomly(years)), getMonth(), Integer.parseInt(getRandomly(dias))));
		return person;
	}
	
	private String getRandomly(String[] array) {
		int index = -1;
		do {
			index = (int) Math.round(Math.random()* array.length -1);
		} while(index < 0);
		return array[index];
	}
	
	private Month getMonth() {
		
		switch (getRandomly(months)) {
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
