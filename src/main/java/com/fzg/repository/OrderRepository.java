package com.fzg.repository;

import com.fzg.entity.Order;

public interface OrderRepository {
    public Order findById(Integer id);
}
