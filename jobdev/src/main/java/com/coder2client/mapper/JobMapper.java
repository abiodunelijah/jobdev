package com.coder2client.mapper;

import com.coder2client.dtos.JobDto;
import com.coder2client.entity.Job;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JobMapper {

    public static JobDto toDto(Job job) {

        return JobDto.builder()
                .id(job.getId())
                .title(job.getTitle())
                .description(job.getDescription())
                .company(job.getCompany())
                .postedDate(String.valueOf(job.getPostedDate()))
                .build();
    }

    public static Job toEntity(JobDto jobDto) {
        return Job.builder()
                .id(jobDto.getId())
                .title(jobDto.getTitle())
                .company(jobDto.getCompany())
                .description(jobDto.getDescription())
                .postedDate(jobDto.getPostedDate() != null
                        ? LocalDateTime.parse(jobDto.getPostedDate())
                        : LocalDateTime.now()) // Set current time if not provided
                .build();
    }
}
