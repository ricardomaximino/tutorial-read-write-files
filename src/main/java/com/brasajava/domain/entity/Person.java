package com.brasajava.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	private String id;
	private String name;
	private String firstname;
	private String lastname;
	private LocalDate birthday;
	private List<PersonalDocument> documents;
	private List<Contact> contacts;
	private List<Address> addresses;
	private boolean active;
	private LocalDateTime systemActivationDateTime;
	private Set<String> documentsToUpdate;
	private Set<String> contactsToUpdate;
	private Set<String> addressesToUpdate;
	
}
