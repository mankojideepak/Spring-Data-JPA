package com.springbootexample.testcases;

import com.springbootexample.config.DemoApplication;
import com.springbootexample.model.BookCategory;
import com.springbootexample.model.Employee;
import com.springbootexample.model.User;
import com.springbootexample.repository.BookCategoryRepository;
import com.springbootexample.repository.EmployeeRepository;
import com.springbootexample.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.TypedQuery;
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

    @Autowired
    private EmployeeRepository employeeRepository;


//    @Test
//    public void createUser() {
//        User user = new User();
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
        System.out.println("\n################ ReadUsers TestCase ################");
        Iterable<User> all = userRepository.findAll();
        all.forEach(e -> System.out.println(e.getId() + " : " + e.getName() + " : " + e.getEmail() + " : " + e.getPhoneNumbers() + "."));
        System.out.println("########################################################");
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

    @Test
    public void readEmail() {
        String s = userRepository.getEmailByName("Vipul");
        System.out.println(s);
    }


//    @Test
//    public void getEmpNameByID() {
//        System.out.println("\n################ getEmpNameByID TestCase ################");
////        System.out.println(employeeRepository.findEmployeeNameByid(74L).getName());
//    }


    @Test
    public void getUserNameByID() {
        System.out.println("\n################ getUserNameByID TestCase ################");
        System.out.println(userRepository.findUserNameById(73).getName());
    }


    @Test
    public void getUserbyName() {
        System.out.println("\n################ getUserbyName TestCase ################");
        User u = userRepository.findUserByName("Vipul");
        System.out.println("Id : " + u.getId() + ", Name : " + u.getName() + ", Email : " + u.getEmail());
    }


    @Test
    public void getcountByDept() {
        System.out.println("\n################ getcountByDept TestCase ################");
        System.out.println(employeeRepository.countByDept("Sales"));
    }

//    @Test
//    public void deletingUser() {
//        System.out.println("\n################ deletingUser TestCase ################");
//        userRepository.deleteById(8);
//        System.out.println("Deletion Successfull");
//    }

    @Test
    public void getUserbyEmail() {
        System.out.println("\n################ getUserbyName TestCase ################");
        User u = userRepository.findByEmail("Tony@Stark.com");
        System.out.println("Id : " + u.getId() + ", Name : " + u.getName() + ", Email : " + u.getEmail());
    }

}
