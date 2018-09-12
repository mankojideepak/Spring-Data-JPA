package com.springbootexample.testcases;

import com.springbootexample.config.DemoApplication;
import com.springbootexample.model.BookCategory;
import com.springbootexample.model.User;
import com.springbootexample.repository.BookCategoryRepository;
import com.springbootexample.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("Context Loaded Successfully");
    }

    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    ManufacturerRepository manufacturerRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

//    @Test
//    public void createUser() {
//
//        user.setName("Bruce Wayne");
//        user.setEmail("bruce@JL.com");
//        user.setPhoneNumbers("9876543210");
//        user.setPhoneNumbers("9876543211");
//        user.setPhoneNumbers("9876543212");
//        userRepository.save(user);
//        System.out.println("Saved");
//    }

    @Test
    public void readUsers() {
        ArrayList<Integer> list = new ArrayList<>();
        userRepository.findAll().forEach(e -> list.add(e.getId()));
        System.out.println("#######################################################");
        for (int i = 0; i < userRepository.count(); i++) {
            User user = userRepository.findById(list.get(i)).orElse(null);
            System.out.println(user.getId() + " : " + user.getName() + " : " + user.getEmail() + " : " + user.getPhoneNumbers());
        }
        System.out.println("#######################################################");
    }

//    @Test
//    public void updateUser()
//    {
//        user = userRepository.findById(4).get();
//        user.setEmail("vipul@kwtc.com");
//        userRepository.save(user);
//        System.out.println("User updated successfully");
//    }
//
//    @Test
//    public void deleteUser() {
//        userRepository.deleteById(9);
//        System.out.println("Deletion successful");
//    }

//    @Test
//    public void readBooks() {
//        ArrayList<Integer> list = new ArrayList<>();
//        bookCategoryRepository.findAll().forEach(e -> list.add(e.getId()));
//        System.out.println("#######################################################");
//        for (int i = 0; i < bookCategoryRepository.count(); i++) {
//            BookCategory bookCategory = bookCategoryRepository.findById(list.get(i)).orElse(null);
//            System.out.println(bookCategory.getId() + " : " + bookCategory.getName());
//        }
//        System.out.println("#######################################################");
//    }

}