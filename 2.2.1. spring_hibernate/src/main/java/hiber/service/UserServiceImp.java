package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   public UserServiceImp(UserDao ud) {
      userDao = ud;
   }

   @Transactional
   @Override
   public void saveUser(User user) {
      userDao.saveUser(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getListOfUsers() {
      return userDao.getListOfUsers();
   }

   @Transactional
   public User getUserByModelAndSeriesOfCar(String model, int series) {
      return userDao.getUserByModelAndSeriesOfCar(model, series);
   }
}
