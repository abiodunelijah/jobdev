package com.coder2client.service;

import com.coder2client.dtos.ApplicationDto;

public interface ApplicationService {

    ApplicationDto applyForJob(Long userId, Long jobId );
}
