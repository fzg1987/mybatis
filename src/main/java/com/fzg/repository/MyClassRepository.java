package com.fzg.repository;

import com.fzg.entity.MyClass;

public interface MyClassRepository {
    public MyClass findById(Integer id);
}
