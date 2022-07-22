package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.saveUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.saveUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.saveUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.saveUser(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Leonid", "Romanov", "romanovsparta@ya.ru");
      user1.setCar(new Car("ВАЗ", 2123));
      userService.saveUser(user1);
      User user2 = new User("Михаил", "Горбачев", null);
      user2.setCar(new Car("ГАЗ", 13));
      userService.saveUser(user2);
      System.out.println(userService.getUserByModelAndSeriesOfCar("ВАЗ", 2123));

      List<User> users = userService.getListOfUsers();
      users.forEach(System.out::println);

      context.close();
   }
}
