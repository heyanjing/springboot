package com.he.maven.dao;

import com.he.maven.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by heyanjing on 2017/5/23 11:48.
 */

public interface DogDao extends JpaRepository<Dog,String> {
}
