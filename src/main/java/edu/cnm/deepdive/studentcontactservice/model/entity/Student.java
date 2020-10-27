package edu.cnm.deepdive.studentcontactservice.model.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Student {

  @NonNull
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_id", nullable = false, updatable = false)
  private Long id;

  @NonNull
  @Column(nullable = false)
  private String lastName;

  @NonNull
  @Column(nullable = false)
  private String firstName;

  @Column
  private String middleName;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private LocalDate enrolled;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDate disenrolled;

  @NonNull
  @OneToMany
      (fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderBy("contact.lastName DESC ")
  private final List<StudentContact> contact = new LinkedList<>();

}
