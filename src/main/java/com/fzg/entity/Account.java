package com.fzg.entity;

import lombok.Data;

import java.util.List;

@Data
public class Account {
    private Integer id;
    private String name;
    private List<Course> courses;
}
