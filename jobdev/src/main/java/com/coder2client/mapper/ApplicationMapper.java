package com.coder2client.mapper;

import com.coder2client.dtos.ApplicationDto;
import com.coder2client.dtos.JobDto;
import com.coder2client.entity.Application;
import com.coder2client.entity.Job;

public class ApplicationMapper {

    public static ApplicationDto toApplicationDto(Application application) {
        return ApplicationDto.builder()
                .id(application.getId())
                .user(application.getUser())
                .job(application.getJob())
                .build();
    }

    public static Application toApplication(ApplicationDto applicationDto) {
        return Application.builder()
                .id(applicationDto.getId())
                .user(applicationDto.getUser())
                .job(applicationDto.getJob())
                .build();
    }
}
