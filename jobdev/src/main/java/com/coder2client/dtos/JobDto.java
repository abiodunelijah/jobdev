package com.coder2client.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobDto {

    private Long id;

    private String title;

    private String description;

    private String company;

    private String postedDate;
}
