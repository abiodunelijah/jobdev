package com.coder2client.controller;

import com.coder2client.dtos.JobDto;
import com.coder2client.entity.Job;
import com.coder2client.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto) {
        return ResponseEntity.ok(jobService.createJob(jobDto));
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }
}
