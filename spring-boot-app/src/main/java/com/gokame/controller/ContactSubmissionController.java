package com.gokame.controller;

import com.gokame.model.ContactSubmission;
import com.gokame.repository.ContactSubmissionRepo;
import com.gokame.service.ContactSubmissionService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/submission")
public class ContactSubmissionController {
    
    private final ContactSubmissionService contactSubmissionService;

    public ContactSubmissionController(ContactSubmissionService contactSubmissionService) {
        this.contactSubmissionService = contactSubmissionService;
    }

    @GetMapping
    public ResponseEntity<List<ContactSubmission>> getAllSubmissions( @RequestParam Map<String, String> queryParams) {
        if (!queryParams.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Reject query parameters
        }
        return ResponseEntity.ok(contactSubmissionService.getAllSubmissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactSubmission> getSubmissionById(@PathVariable Long id) {
        return contactSubmissionService.getSubmissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContactSubmission> createSubmission(@RequestBody @Valid ContactSubmission submission,BindingResult result, @RequestParam Map<String, String> queryParams) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null); 
        }
        if (!queryParams.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Reject query parameters
        }
        ContactSubmission createdSubmission = contactSubmissionService.createSubmission(submission);
        return ResponseEntity.ok(createdSubmission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        contactSubmissionService.deleteSubmission(id);
        return ResponseEntity.noContent().build();
    }
}