package com.newland.cxfbasesb.dao;

import com.newland.cxfbasesb.vo.People;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository
        extends CrudRepository<People, Long> {

    List<People> findPeopleByName(String name);
    People findPeopleById(Long id);
}
