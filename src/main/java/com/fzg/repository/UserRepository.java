package com.fzg.repository;

import com.fzg.entity.User;

public interface UserRepository {
    public User findByUser(User user);
    public int update(User user);
}
