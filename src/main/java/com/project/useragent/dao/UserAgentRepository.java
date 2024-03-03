package com.project.useragent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAgentRepository extends CrudRepository<UserAgentEntity, Long> {
}
