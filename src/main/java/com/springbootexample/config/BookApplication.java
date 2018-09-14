package com.springbootexample.config;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springbootexample.*")
@EntityScan(basePackages = "com.springbootexample.*")
@EnableJpaRepositories(basePackages = {"com.springbootexample.*"})
@SpringBootApplication
public class BookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

//    @Autowired
//    BookCategoryRepository bookCategoryRepository;

    @Override
    public void run(String... args) {
////         ################ INSERTING VALUES INTO BOOKCATEGORY ENTITY ##################
//        BookCategory categoryA = new BookCategory("Mystery");
//        Set bookAs = new HashSet<Book>(){{
//            add(new Book("Hound Of Baskerville", categoryA));
//            add(new Book("Murder On Orient Express", categoryA));
//            add(new Book("And Then There Were None", categoryA));
//        }};
//        categoryA.setBooks(bookAs);
//
//        BookCategory categoryB = new BookCategory("Philosophical");
//        Set bookBs = new HashSet<Book>(){{
//            add(new Book("The Secret", categoryB));
//            add(new Book("The Magic", categoryB));
//            add(new Book("The Power", categoryB));
//        }};
//        categoryB.setBooks(bookBs);
//
//        bookCategoryRepository.saveAll(new HashSet<BookCategory>() {{
//            add(categoryA);
//            add(categoryB);
//        }});
    }
}
