package com.gokame.repository;

import com.gokame.model.ContactSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactSubmissionRepo extends JpaRepository<ContactSubmission, Long> {

}