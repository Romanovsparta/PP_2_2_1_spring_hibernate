package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sf) {
      sessionFactory = sf;
   }

   @Override
   public void saveUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListOfUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getUserByModelAndSeriesOfCar(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery(
              "FROM User WHERE car.model = :model AND car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return (User) query.getSingleResult();
   }
}
