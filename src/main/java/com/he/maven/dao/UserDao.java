package com.he.maven.dao;

import com.he.maven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by heyanjing on 2017/5/23 11:48.
 */

public interface UserDao extends JpaRepository<User, String> {
    List<User> findByName(String name);
}
