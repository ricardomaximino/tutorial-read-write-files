package com.brasajava.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalDocument {
	private String id;
	private String type;
	private String document;
	private LocalDate expirationDate;
	private boolean expired;
	private boolean cancelled;
	private boolean principal;
	private Person person;
	
}
