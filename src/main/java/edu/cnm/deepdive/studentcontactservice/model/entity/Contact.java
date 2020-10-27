package edu.cnm.deepdive.studentcontactservice.model.entity;

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
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Contact {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "contact_id",nullable = false, updatable = false)
  private Long id;

  @NonNull
  @Column(nullable = false)
  private String lastName;

  @NonNull
  @Column(nullable = false)
  private String firstName;

  private String middleName;

  @NonNull
  @Column(nullable = false)
  private String phoneNumber;

  private String smsNumber;

  private String email;

  @NonNull
  @OneToMany
      (fetch = FetchType.LAZY, mappedBy = "student", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("student.lastName DESC ")
  private final List<StudentContact> students = new LinkedList<>();

}
