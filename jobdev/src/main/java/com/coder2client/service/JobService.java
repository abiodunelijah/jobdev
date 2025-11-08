package com.coder2client.service;

import com.coder2client.dtos.JobDto;
import com.coder2client.entity.Job;
import com.coder2client.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    JobDto createJob(JobDto jobDto);
    List<JobDto> getAllJobs();
    JobDto updateJob(Long id, JobDto jobDto);
    JobDto deleteJob(Long id);
    JobDto getJobById(Long id);



}
