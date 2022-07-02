package com.fzg.repository;

import com.fzg.entity.Course;

public interface CourseRepository {
    public Course findById(Integer id);
}
