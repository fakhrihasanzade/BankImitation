package serviceImpl;

import entity.User;
import service.CommonService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements CommonService<User>, UserService {

    static List<User> userList = new ArrayList<>();


    static {
        userList.add(new User(1, "Fexri Hesenzade", 26, "554402066", 500, 8, 600));
        userList.add(new User(2, "Elvin Yusubov", 20, "554686972", 5000, 4, 500));
        userList.add(new User(3, "Vusal Qulamov", 20, "774263956", 3000, 5, 300));
        userList.add(new User(4, "Nihad Zeynalov", 21, "504402766", 3000, 6, 300));
        userList.add(new User(5, "Yusif Hesenli", 19, "514302066", 3000, 3, 300));
    }


    @Override
    public void add(User object) {
        userList.add(object);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getById(Integer id) {
        return userList.get(id - 1);
    }

    @Override
    public void updateById(Integer id, User object) {
        for (User u : userList) {
            if (u.getId().equals(id)) {
                userList.set(u.getId(), object);
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        userList.remove(userList.get(id - 1));
    }

    @Override
    public List<User> getMoney(Integer debt, Integer age, Integer salary) {
        return userList.stream().filter(user -> user.getDebt() <= debt && user.getAge() >= age && user.getSalary() >= salary).toList();
    }

    @Override
    public List<User> getByScore(Integer score) {
        return userList.stream().filter(user -> user.getScore() >= score).toList();
    }

    @Override
    public List<User> getByPrefixe(String prefix) {
        return userList.stream().filter(user -> user.getTelephoneNumber().contains(prefix)).toList();
    }

    @Override
    public List<User> getByName(String name) {
        return userList.stream().filter(user -> user.getName().contains(name)).toList();
    }

    @Override
    public List<User> getByAgeWithMap(Integer age, Integer age1) {
        return userList.stream()
                .map(m -> new User(m.getId(), m.getName(), m.getAge() + age1, m.getTelephoneNumber(), m.getDebt(), m.getScore(), m.getSalary()))
                .filter(user -> user.getAge() == age).toList();
    }

    @Override
    public List<User> endDebt(Integer endDebt) {
        return userList.stream()
                .map(m -> new User(m.getId(), m.getName(), m.getAge(), m.getTelephoneNumber(), m.getDebt() - endDebt, m.getScore(), m.getSalary()))
                .filter(user -> user.getScore() == 0).toList();
    }

    @Override
    public List<User> minimalSalary(Integer minSalary) {
        return userList.stream().filter(user -> user.getSalary() == minSalary).toList();
    }
}
