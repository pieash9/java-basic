package com.pieash9.SpringBoot.start.controller;

import com.pieash9.SpringBoot.start.entity.Department;
import com.pieash9.SpringBoot.start.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentAddress("Ahmedabad").departmentName("IT").departmentCode("IT-01").departmentId(1L).build();

    }

    @Test
    void saveDepartment() throws Exception {
      Department  inputDepartment = Department.builder().departmentAddress("Ahmedabad").departmentName("IT").departmentCode("IT-01").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"departmentName\":\"IT\",\n" +
                "    \"departmentAddress\":\"Ahmedabad\",\n" +
                "    \"departmentCode\":\"IT-01\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath(("$.departmentName")).value(department.getDepartmentName()));
    }
}