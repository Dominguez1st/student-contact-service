package edu.cnm.deepdive.studentcontactservice.model.entity;

import javax.persistence.Entity;

@Entity
public class StudentContact {

  private Long id;

  private Student studentId;

  private Contact contactId;

  private Boolean primary;

  private Relationship relationship;

  public enum Relationship {
    PARENT, GUARDIAN, SIBLING, OTHER;
  }
}
