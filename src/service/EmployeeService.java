package service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {

    void updateByNameAndPosition(String name, String position, Employee object);

    void updatePasswordById(String password, Integer id);

    List<Employee> getEmployeeByDepartament(String departament);

    List<Employee> getPension(Integer age);

    List<Employee> getPension1(Integer pensionYear);

    List<Employee> getEmployeeByExperience(Integer exp);

}
