package edu.cnm.deepdive.studentcontactservice.model.entity;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class Student {
  
  private Long id;

  private String lastName;

  private String firstName;

  private String middleName;

  private LocalDate enrolled;

  private LocalDate disenrolled;

}
