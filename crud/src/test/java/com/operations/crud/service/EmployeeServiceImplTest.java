package com.operations.crud.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operations.crud.dto.EmployeeDto;
import com.operations.crud.dto.mapper.EmployeeMapper;
import com.operations.crud.model.Department;
import com.operations.crud.model.Employee;
import com.operations.crud.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeMapper employeeMapper;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    Employee testEmpData = new Employee(1l, "john", "snow", 45,
            "male", 657000.0, "john@snow.com");

    @Test
    public void allEmployee() {
        List<Employee> testEmployee = new ArrayList<>();
        testEmployee.add(testEmpData);
        when(employeeRepository.findAll()).thenReturn(testEmployee);
        assertEquals(1, employeeService.getAll().size());
    }


    @Test
    public void createEmployee() throws JsonProcessingException {

        Employee employee = new Employee(1l, "john", "snow", 45,
                "male", 657000.0, "john@snow.com");

        Employee employee1 = new Employee(1l, "john", "snow", 45,
                "male", 657000.0, "john@snow.com");

        Mockito.when(employeeRepository.save(employee)).thenReturn(employee1);

        EmployeeDto employeeDto = new EmployeeDto(1l, "john", "snow", "male",
                45, 657000.0, "john@snow.com");
        assertEquals(employee1.toString(),employeeDto.toString());

    }



    @Test
    public void updateEmployee() {
    EmployeeDto employeeDto = new EmployeeDto(1l, "john", "snow", "male",
            45, 657000.0, "john@snow.com");
        when(employeeRepository.save(testEmpData)).thenReturn(testEmpData);
        assertEquals(testEmpData.toString(), employeeDto.toString());
    }

}