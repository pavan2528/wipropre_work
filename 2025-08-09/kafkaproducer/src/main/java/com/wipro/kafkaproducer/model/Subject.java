package com.wipro.kafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private String subjectCode;
    private String subjectValue;
}
