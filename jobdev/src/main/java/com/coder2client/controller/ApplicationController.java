package com.coder2client.controller;


import com.coder2client.dtos.ApplicationDto;
import com.coder2client.entity.Application;
import com.coder2client.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply/{userId}/{jobId}")
    public ResponseEntity<ApplicationDto> applyToJobs(@PathVariable Long userId, @PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.applyForJob(userId, jobId));
    }
















}
