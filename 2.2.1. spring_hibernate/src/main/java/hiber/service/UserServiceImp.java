package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional
   public void add(Car car) {
      userDao.add(car);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Car> listCars() {
      return userDao.listCars();
   }

   @Override
   @Transactional
   public User findUser(String model, int series) {
      return userDao.findUser(model, series);
   }
}
