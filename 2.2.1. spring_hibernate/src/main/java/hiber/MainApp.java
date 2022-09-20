package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("Opel", 123));
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(new Car("Kia", 1234));
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(new Car("Zapor", 12));
      userService.add(user3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(new Car("Niva", 666));
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }

      System.out.println(userService.findUser("Niva", 666).toString());

      context.close();
   }
}
