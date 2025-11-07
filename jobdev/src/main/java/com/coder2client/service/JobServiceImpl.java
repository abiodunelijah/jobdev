package com.coder2client.service;

import com.coder2client.dtos.JobDto;
import com.coder2client.dtos.Response;
import com.coder2client.entity.Job;
import com.coder2client.mapper.JobMapper;
import com.coder2client.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobDto createJob(JobDto jobDto) {
        log.info("createJob");
        Job job = JobMapper.toEntity(jobDto);
        Job savedJob = jobRepository.save(job);
        return JobMapper.toDto(savedJob);

    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream().map(JobMapper::toDto).collect(Collectors.toList());
    }







}
