package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;
import system.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserService() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    public void addUser(User user){

        System.out.println("add service");
        userDao.addUser(user);
    }

    @Transactional
    public List<User> getAllUser(){
        System.out.println("getAllUser service");
        return this.userDao.getAllUsers();
    }

    @Transactional
    public void removeUser (int id){
        this.userDao.removeUser(id);
    }

    @Transactional
    public void getUserById(int id){
        this.userDao.getUserById(id);
    }




}
