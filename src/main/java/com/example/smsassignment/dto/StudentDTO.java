package com.example.smsassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private int stdID;
    private String stdName;
    private String stdAddress;
    private String stdMNumber;
}
