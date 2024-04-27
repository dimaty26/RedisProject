package com.zmeev.redisproject.repository;

import com.zmeev.redisproject.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
}
