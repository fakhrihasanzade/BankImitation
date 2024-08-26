package serviceImpl;

import entity.Employee;
import exception.MyException;
import service.CommonService;
import service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements CommonService<Employee>, EmployeeService {

    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "Fexri Hesenzade", 26, "554402066", "Mutexessis", "fexri41", 10, "kredit"));
        employeeList.add(new Employee(3, "Fexri Hesenzade", 26, "554402066", "Mutexessis", "fexri41", 10, "kredit"));
        employeeList.add(new Employee(4, "Fexri Hesenzade", 26, "554402066", "Mutexessis", "fexri41", 10, "kredit"));
        employeeList.add(new Employee(5, "Fexri Hesenzade", 26, "554402066", "Mutexessis", "fexri41", 10, "kredit"));
        employeeList.add(new Employee(6, "Fexri Hesenzade", 26, "554402066", "Mutexessis", "fexri41", 10, "kredit"));
    }


    @Override
    public void add(Employee object) {
        employeeList.add(object);
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee getById(Integer id) {
        try {
            return employeeList.stream().filter(e -> e.getId().equals(id)).toList().get(0);
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    @Override
    public void updateById(Integer id, Employee object) {
        try {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getId().equals(id)) {
                    employeeList.set(i, object);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            employeeList.remove(employeeList.get(id - 1));
        }catch(MyException ex){
            ex.printStackTrace();
        }
        }

    @Override
    public void updateByNameAndPosition(String name, String position, Employee object) {
        employeeList.stream().filter(e -> {
            if(e.getName().equals(name) && e.getPosition().equals(position)){
                e.setName(object.getName());
                e.setPosition(object.getPosition());
                e.setDepartament(object.getDepartament());
                e.setExperience(object.getExperience());
                e.setPassword(object.getPassword());
                e.setAge(object.getAge());
                e.setTelephoneNumber(object.getTelephoneNumber());
                return true;
            }
            return true;
        });
    }
    @Override
    public void updatePasswordById(String password, Integer id) {
        for(Employee emp:employeeList){
            if(emp.getId().equals(id)){
                emp.setPassword(password);
            }
        }

    }

    @Override
    public List<Employee> getEmployeeByDepartament(String departament) {
        return employeeList.stream().filter(emp->emp.getDepartament().equals(departament)).toList();
    }

    @Override
    public List<Employee> getPension(Integer age) {
        return employeeList.stream().filter(emp->emp.getAge().equals(age)).toList();
    }

    @Override
    public List<Employee> getPension1(Integer pensionYear) {
        return employeeList.stream()
                .map(m->new Employee(m.getId(),m.getName(),m.getAge()+pensionYear,m.getTelephoneNumber()
                        ,m.getPosition(),m.getPassword(),m.getExperience(),m.getDepartament()))
                .filter(emp->emp.getAge().equals(pensionYear)).toList();
    }

    @Override
    public List<Employee> getEmployeeByExperience(Integer exp) {
        return employeeList.stream().filter(emp->emp.getExperience().equals(exp)).toList();
    }
}
