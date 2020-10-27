package edu.cnm.deepdive.studentcontactservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    indexes = {
     @Index(columnList = "relationship"),
     @Index(columnList = "student,contact ")
    }
)
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
  @Enumerated(value = EnumType.ORDINAL)
  @Column(name = "relationship_type", nullable = false)
  private Relationship relationship = Relationship.PARENT;

  @NonNull
  public Long getId() {
    return id;
  }

  @NonNull
  public Student getStudent() {
    return student;
  }

  @NonNull
  public Contact getContact() {
    return contact;
  }

  public void setContact(@NonNull Contact contact) {
    this.contact = contact;
  }

  @NonNull
  public Boolean getPrimary() {
    return primary;
  }

  public void setPrimary(@NonNull Boolean primary) {
    this.primary = primary;
  }

  @NonNull
  public Relationship getRelationship() {
    return relationship;
  }

  public void setRelationship(
      @NonNull Relationship relationship) {
    this.relationship = relationship;
  }

  public enum Relationship {
    PARENT, GUARDIAN, SIBLING, OTHER;
  }
}
