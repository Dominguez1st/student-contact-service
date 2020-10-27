package edu.cnm.deepdive.studentcontactservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class StudentContact {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_contact_id",nullable = false, updatable = false)
  private Long id;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_id", nullable = false, updatable = false)
  private Student student;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contact_id", nullable = false)
  private Contact contact;

  @NonNull
  @Column(nullable = false)
  private Boolean primary;

  @NonNull
  @Column(name = "relationship_type", nullable = false)
  private Relationship relationship;

  public enum Relationship {
    PARENT, GUARDIAN, SIBLING, OTHER;
  }
}
