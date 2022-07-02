package com.fzg.repository;

import com.fzg.entity.Student;

public interface StudentRepository {
    public Student findById(Integer id);
}
