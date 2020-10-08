package com.resources.Resources.Repository;

import com.resources.Resources.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Resource findByResourceName(String resourceName);
}
