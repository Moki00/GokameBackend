package com.gokame.model;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "contact_submission")
public class ContactSubmission {
    private @Id
  @GeneratedValue Long id;
  @NotBlank(message = "Name is mandatory")
  private String name;
  @NotBlank(message = "email is mandatory")
  @Email(message = "Please provide a valid email address")
  private String email;
  @NotBlank(message = "interest is mandatory")
  @Pattern(regexp = "Website Development|SEO Optimization|Social Media Marketing", message = "Interest must be one of: Website Development, SEO Optimization, Social Media Marketing")
  private String interest;
  @NotBlank(message = "message is mandatory")
  private String message;
  public ContactSubmission() {}

  public ContactSubmission(String name, String email, String interest, String message) {

    setEmail(email);
    setName(name);
    setInterest(interest);
    setMessage(message);
  }


  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof ContactSubmission))
      return false;
      ContactSubmission sub = (ContactSubmission) o;
    return Objects.equals(this.id, sub.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.message);
  }

  @Override
  public String toString() {
    return String.format("%s with email %s has send an message regarding %s with message: %s", getName(),getEmail(),getInterest(),getMessage());
  }
}
