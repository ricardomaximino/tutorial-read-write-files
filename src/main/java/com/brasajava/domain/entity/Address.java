package com.brasajava.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address{
	private String id;
	private String country;
	private String state;
	private String city;
	private String town;
	private String neighborhood;
	private String street;
	private String number;
	private String postCode;
	private String details; 
	private long longitude; 
	private long latitude;
	private boolean inactive;
	private boolean cancelled;
	private boolean principal;
	private Person person;
	
}
