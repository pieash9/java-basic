package com.pieash9.SpringBoot.start.repository;

import com.pieash9.SpringBoot.start.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Mechanical Engineering").departmentAddress("Delhi").departmentCode("ME-01").build();

        entityManager.persist(department);
    }

    @Test
    public  void whenFindById_thenReturnDepartment(){
     Department department = departmentRepository.findById(1L).get();

     assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}