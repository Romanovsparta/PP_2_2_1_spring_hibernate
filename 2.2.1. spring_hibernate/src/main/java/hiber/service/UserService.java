package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getListOfUsers();
    User getUserByModelAndSeriesOfCar(String model, int series);
}
