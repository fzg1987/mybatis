package com.fzg.repository;

import com.fzg.entity.Customer;

public interface CustomerRepository {
    public Customer findById(Integer id);
}
