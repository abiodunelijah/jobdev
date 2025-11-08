package com.coder2client.dtos;

import com.coder2client.entity.Job;
import com.coder2client.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

    private Long id;

    private User user;

    private Job job;

    public ApplicationDto(User user, Job job) {
        this.user = user;
        this.job = job;
    }
}
