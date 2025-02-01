package com.gokame.service;

import com.gokame.model.ContactSubmission;
import com.gokame.repository.ContactSubmissionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactSubmissionService {
    
    private final ContactSubmissionRepo contactSubmissionRepo;

    public ContactSubmissionService(ContactSubmissionRepo contactSubmissionRepo) {
        this.contactSubmissionRepo = contactSubmissionRepo;
    }

    public List<ContactSubmission> getAllSubmissions() {
        return contactSubmissionRepo.findAll();
    }

    public Optional<ContactSubmission> getSubmissionById(Long id) {
        return contactSubmissionRepo.findById(id);
    }

    public ContactSubmission createSubmission(ContactSubmission sub) {
        return contactSubmissionRepo.save(sub);
    }

    public void deleteSubmission(Long id) {
        contactSubmissionRepo.deleteById(id);
    }
}
