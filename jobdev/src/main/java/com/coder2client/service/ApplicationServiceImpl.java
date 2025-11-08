package com.coder2client.service;

import com.coder2client.dtos.ApplicationDto;
import com.coder2client.entity.Application;
import com.coder2client.entity.Job;
import com.coder2client.entity.User;
import com.coder2client.exception.ResourcesNotFoundException;
import com.coder2client.mapper.ApplicationMapper;
import com.coder2client.repository.ApplicationRepository;
import com.coder2client.repository.JobRepository;
import com.coder2client.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;


    @Override
    public ApplicationDto applyForJob(Long userId, Long jobId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourcesNotFoundException("user not found"));

        Job job = jobRepository.findById(jobId).orElseThrow(() -> new ResourcesNotFoundException("job not found"));

        Application application = new Application(user, job);
        Application savedApplication = applicationRepository.save(application);

        return ApplicationMapper.toApplicationDto(savedApplication);
    }
}
