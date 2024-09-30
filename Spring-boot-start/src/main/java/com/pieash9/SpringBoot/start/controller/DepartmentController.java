package com.pieash9.SpringBoot.start.controller;

import com.pieash9.SpringBoot.start.entity.Department;
import com.pieash9.SpringBoot.start.error.DepartmentNotFoundException;
import com.pieash9.SpringBoot.start.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

        @Autowired
        private  DepartmentService departmentService;

        private final Logger Logger = LoggerFactory.getLogger(DepartmentController.class);

        @PostMapping("/departments")
                public Department saveDepartment(@Valid @RequestBody Department department) {
                Logger.info("Inside saveDepartment of DepartmentController");
                return  departmentService.saveDepartment(department);
        }

        @GetMapping("/departments")
        public List<Department> fetchDepartmentList(){
                Logger.info("Inside getDepartment of fetchDepartmentList");
                return  departmentService.fetchDepartmentList();
        }

        @GetMapping("/departments/{id}")
        public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
                return departmentService.fetchDepartmentById(departmentId);
        }

        @DeleteMapping("/departments/{id}")
        public  String deleteDepartmentById(@PathVariable("id")  Long departmentId){
                  departmentService.deleteDepartmentById(departmentId);
                return "department deleted successfully";
        }

        @PutMapping("/departments/{id}")
        public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
                return departmentService.updateDepartmentById(departmentId, department);
        }

        @GetMapping("departments/name/{name}")
        public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
                return  departmentService.fetchDepartmentByName(departmentName);
        }
}
