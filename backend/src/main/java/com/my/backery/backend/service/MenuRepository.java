package com.my.backery.backend.service;

import com.my.backery.backend.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface MenuRepository extends JpaRepository<MenuItem, Integer> {
    @RestResource
    MenuItem findById(@Param("id") Integer id);
}
