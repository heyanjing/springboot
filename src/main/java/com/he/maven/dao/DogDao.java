package com.he.maven.dao;

import com.he.maven.entity.Dog;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by heyanjing on 2017/5/23 11:48.
 */
@CacheConfig(cacheNames = "userCheatCache")
public interface DogDao extends JpaRepository<Dog, String> {
    @Cacheable
    List<Dog> findByName(String name);
}
