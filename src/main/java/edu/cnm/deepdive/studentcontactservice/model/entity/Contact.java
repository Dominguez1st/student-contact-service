package edu.cnm.deepdive.studentcontactservice.model.entity;

import javax.persistence.Entity;

@Entity
public class Contact {

  private Long id;

  private String lastName;

  private String firstName;

  private String middleName;

  private String phoneNumber;

  private String smsNumber;

  private String email;

}
