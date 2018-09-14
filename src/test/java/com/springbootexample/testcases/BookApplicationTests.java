package com.springbootexample.testcases;


import com.springbootexample.config.BookApplication;
import com.springbootexample.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookApplication.class)
public class BookApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Test
    public void contextLoads() {
        System.out.println("\n--------------#0 contextLoads---------------------");
        System.out.println("BookApplication Context Loaded Successfully");
    }

    @Test
    public void findBooksTest() {
        System.out.println("\n############### eg1-findBooksTest ###############");
        List<Book> books = em.createNamedQuery("Book.findBooks", Book.class).getResultList();
        for (Book b : books) {
            System.out.println("ID : " + b.getId() + ", Name : " + b.getName());
        }
    }

    @Test
    public void findcategories() {
        System.out.println("\n############### eg2:findcategories ###############");
        List<Object[]> categories = em.createNamedQuery("Book.categories").getResultList();
        for (Object[] t : categories)
            System.out.println(t[0] + " -- " + t[1] + " -- " + t[2]);
    }

    @Test
    public void findBookbyIdTest() {
        System.out.println("\n############### eg3-findBookbyIdTest ###############");
        Book b = em.createNamedQuery("Book.findBookbyId", Book.class).setParameter("id", 85).getSingleResult();
        System.out.println("ID : " + b.getId() + ", Name : " + b.getName());
    }

    @Test
    public void findBookbyNameTest() {
        System.out.println("\n############### eg4-findBookbyNameTest ###############");
        List<Book> books = em.createNamedQuery("Book.findBookbyName", Book.class).setParameter(1, "The Power").getResultList();
        for (Book b : books) {
            System.out.println("ID : " + b.getId() + ", Name : " + b.getName());
        }
    }

    @Test
    public void findBookUsingLikeTest() {
        System.out.println("\n############### eg5-findBookUsingLikeTest ###############");
        List<Book> books = em.createNamedQuery("Book.findBookUsingLike", Book.class).setParameter("name", "The").getResultList();
        for (Book b : books) {
            System.out.println("ID : " + b.getId() + ", Name : " + b.getName());
        }
    }
}
