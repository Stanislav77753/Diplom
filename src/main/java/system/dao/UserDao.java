package system.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.List;


@Repository
public class UserDao {
    private SessionFactory sessionFactory;

    public UserDao(){
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user){
        System.out.println("add DAO");
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.persist(user);
        System.out.println("user added");
        session.close();

    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        System.out.println("dao getAllUsers");
        List<User> userList = session.createQuery("from User").list();
        session.close();

        return userList;
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user!=null){
            session.delete(user);
        }
        System.out.println("user remove");
    }
    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        System.out.println("user get");
        return user;
    }
}
