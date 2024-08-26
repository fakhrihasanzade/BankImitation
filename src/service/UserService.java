package service;

import entity.User;

import java.util.List;

public interface UserService {

    List<User> getMoney(Integer debt,Integer age,Integer salary);
    List<User> getByScore(Integer score);
    List<User> getByPrefixe(String prefix);
    List<User> getByName(String name);
    List<User> getByAgeWithMap(Integer age,Integer age1);
    List<User> endDebt(Integer endDebt);
    List<User> minimalSalary(Integer minSalary);

}
