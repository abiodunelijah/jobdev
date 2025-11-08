package com.coder2client.service;

import com.coder2client.dtos.JobDto;
import com.coder2client.entity.Job;
import com.coder2client.exception.ResourcesNotFoundException;
import com.coder2client.mapper.JobMapper;
import com.coder2client.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public JobDto updateJob(Long id, JobDto jobDto) {

        log.info("updateJob");
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Job not found"));
        Job jobToUpdate = JobMapper.toEntity(jobDto);

        return JobMapper.toDto(jobRepository.save(jobToUpdate));
    }

    @Override
    public JobDto deleteJob(Long id) {

        log.info("deleteJob");
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Job not found"));
        jobRepository.delete(job);
        return JobMapper.toDto(job);
    }

    @Override
    public JobDto getJobById(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("job not found"));

        return JobMapper.toDto(job);
    }


}
