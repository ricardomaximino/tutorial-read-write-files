package com.brasajava.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
	private String id;
	private String type;
	private String contact;
	private boolean inactive;
	private boolean cancelled;
	private boolean principal;
	private Person person;
	
}
