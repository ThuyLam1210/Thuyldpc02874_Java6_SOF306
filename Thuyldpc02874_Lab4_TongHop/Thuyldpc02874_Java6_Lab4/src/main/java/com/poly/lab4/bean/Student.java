package com.poly.lab4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	String fullname;
	String email;
	Double marks;
	Boolean gender;
	String country;
}
