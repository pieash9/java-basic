package com.pieash9.SpringBoot.start.service;

import com.pieash9.SpringBoot.start.entity.Department;
import com.pieash9.SpringBoot.start.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long departmentId);

  public Department updateDepartmentById(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
