package com.fzg.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private Classes classes;
}
