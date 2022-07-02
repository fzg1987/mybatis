package com.fzg.repository;

import com.fzg.entity.Account;

public interface AccountRepository {
    public Account findById(Integer id);
}
