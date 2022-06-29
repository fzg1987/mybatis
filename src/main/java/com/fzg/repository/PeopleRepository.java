package com.fzg.repository;

import com.fzg.entity.People;

import java.util.List;

public interface PeopleRepository {
    public int save(People people);
    public int deleteById(Integer id);
    public int update(People people);
    public People findById(Integer id);
    public List<People> findAll();
}
