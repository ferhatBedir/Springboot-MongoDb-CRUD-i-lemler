package com.ferhat.springmongodemo.service;

import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user) {
        User user1 = userRepository.findOneByUserId(user.getUserId());
        if (user.getUserId() == null) {
            System.out.println("User Id Alanının doldurulması zorunludur.. ");
        } else if (user1 != null) {
            System.out.println("Kişi zaten Db'ye kayıtlı.. ");
        } else {
            userRepository.save(user);
            System.out.println("Kişi Db'ye kaydedildi.. ");
            System.out.println("******************************************");
            System.out.println("Kayıt Edilen Kişi Bilgileri");
            System.out.println("User Id --> " + user.getUserId());
            System.out.println("User Name --> " + user.getUserFirstName());
            System.out.println("User Surname --> " + user.getUserLastName());
            System.out.println("User Email --> " + user.getUserEmail());
            System.out.println("User Department Name --> " + user.getUserDepartmentName());
        }
    }

    public void getUser(Long id) {
        User user = userRepository.findOneByUserId(id);
        if (user == null) {
            throw new NullPointerException("Db'de " + id + "Id'li kayıt bulunamadı.. ");
        } else {
            System.out.println("******************************************");
            System.out.println("Kişi Bilgileri");
            System.out.println("User Id --> " + user.getUserId());
            System.out.println("User Name --> " + user.getUserFirstName());
            System.out.println("User Surname --> " + user.getUserLastName());
            System.out.println("User Email --> " + user.getUserEmail());
            System.out.println("User Department Name --> " + user.getUserDepartmentName());
        }
    }

    public void deleteUser(Long id) {
        User user = userRepository.findOneByUserId(id);
        if (user == null) {
            throw new NullPointerException("Db'de " + id + "Id'li kayıt bulunamadı.. ");
        } else {
            userRepository.delete(user);
            System.out.println("Kişi Bilgileri Db'den silindi..");
        }
    }

    public void updateUser(User user) {
        User userTemp = userRepository.findOneByUserId(user.getUserId());
        if (userTemp == null) {
            throw new NullPointerException("Db'de " + user.getUserId() + "Id'li kayıt bulunamadı.. ");
        } else {
            userTemp.setUserFirstName(user.getUserFirstName());
            userTemp.setUserLastName(user.getUserLastName());
            userTemp.setUserEmail(user.getUserEmail());
            userTemp.setUserDepartmentName(user.getUserDepartmentName());
            userRepository.save(userTemp);
            System.out.println("Kişi Bilgileri Güncellendi ve Db'ye kaydedildi.. ");
            System.out.println("******************************************");
            System.out.println("Güncellenen Kişi Bilgileri");
            System.out.println("User Id --> " + userTemp.getUserId());
            System.out.println("User Name --> " + userTemp.getUserFirstName());
            System.out.println("User Surname --> " + userTemp.getUserLastName());
            System.out.println("User Email --> " + userTemp.getUserEmail());
            System.out.println("User Department Name --> " + userTemp.getUserDepartmentName());
        }
    }

    public void getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Kayıtlı Kişi Listesi");
        if (users.size() == 0) {
            System.out.println("Db'ye kayıtlı kişi yok..");
        } else {
            for (User s : users) {
                System.out.println("******************************************");
                System.out.println("Kişi Bilgileri");
                System.out.println("User Id --> " + s.getUserId());
                System.out.println("User Name --> " + s.getUserFirstName());
                System.out.println("User Surname --> " + s.getUserLastName());
                System.out.println("User Email --> " + s.getUserEmail());
                System.out.println("User Department Name --> " + s.getUserDepartmentName());
            }
        }

    }

    public void deleteAllusers() {
        userRepository.deleteAll();
        System.out.println("Db'ye kayıtlı tüm user bilgileri silindi.. ");
    }

    public void addUsers(List<User> users) {
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = userRepository.findOneByUserId(users.get(i).getUserId());
            if (user == null) {
                userRepository.save(users.get(i));
            } else {
                System.out.println(user.getUserId() + "Id'li kişi zaten Db'ye kayıtlı.");
            }
        }
    }

    public void getUserName(String name) {
        List<User> users = userRepository.findOneByUserFirstNameIgnoreCase(name);
        if (users.size() == 0) {
            System.out.println("Aradiğiniz isimde bir kayıt bulunamadı.");
        } else {
            for (User s : users) {
                System.out.println("User Id --> " + s.getUserId());
                System.out.println("User Name --> " + s.getUserFirstName());
                System.out.println("User Surname --> " + s.getUserLastName());
                System.out.println("User Email --> " + s.getUserEmail());
                System.out.println("User Department Name --> " + s.getUserDepartmentName());
            }
        }

    }
}
