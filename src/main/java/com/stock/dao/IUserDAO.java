package com.stock.dao;

import com.stock.model.User;

public interface IUserDAO {
    User findByUsernameAndPassword(String username, String password);
}
