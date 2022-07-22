package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void saveUser(User user);
   List<User> getListOfUsers();
   User getUserByModelAndSeriesOfCar(String model, int series);
}
