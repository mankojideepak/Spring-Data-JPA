package com.springbootexample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;


@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springbootexample.*")
@EntityScan(basePackages = "com.springbootexample.*")
@EnableJpaRepositories(basePackages = {"com.springbootexample.*"})
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

//    @Autowired
//    private ProductRepository ProductRepository;
//
//    @Autowired
//    private BookCategoryRepository bookCategoryRepository;
//
//    @Autowired
//    private ManufacturerRepository ManufacturerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
//		// save a couple of Products
//		Manufacturer ManufacturerA = new Manufacturer("Manufacturer A");
//		Manufacturer ManufacturerB = new Manufacturer("Manufacturer B");
//		Manufacturer ManufacturerC = new Manufacturer("Manufacturer C");
//
//		ProductRepository.saveAll(new HashSet<Product>(){{
//			add(new Product("Product A", new HashSet<Manufacturer>(){{
//				add(ManufacturerA);
//				add(ManufacturerB);
//			}}));
//
//			add(new Product("Product B", new HashSet<Manufacturer>(){{
//				add(ManufacturerA);
//				add(ManufacturerC);
//			}}));
//		}});
//
//		// fetch all Products
//		for(Product Product : ProductRepository.findAll()) {
//			logger.info(Product.toString());
//		}
//
//		// save a couple of Manufacturers
//		Product ProductA = new Product("Product A");
//		Product ProductB = new Product("Product B");
//
//		ManufacturerRepository.saveAll(new HashSet<Manufacturer>() {{
//			add(new Manufacturer("Manufacturer A", new HashSet<Product>() {{
//				add(ProductA);
//				add(ProductB);
//			}}));
//
//			add(new Manufacturer("Manufacturer B", new HashSet<Product>() {{
//				add(ProductA);
//				add(ProductB);
//			}}));
//		}});
//
//		// fetch all Manufacturers
//		for(Manufacturer Manufacturer : ManufacturerRepository.findAll()) {
//			logger.info(Manufacturer.toString());
//		}


//        // save a couple of categories
//        BookCategory categoryA = new BookCategory("Category A");
//        Set bookAs = new HashSet<Book>(){{
//            add(new Book("Book A1", categoryA));
//            add(new Book("Book A2", categoryA));
//            add(new Book("Book A3", categoryA));
//        }};
//        categoryA.setBooks(bookAs);
//
//        BookCategory categoryB = new BookCategory("Category B");
//        Set bookBs = new HashSet<Book>(){{
//            add(new Book("Book B1", categoryB));
//            add(new Book("Book B2", categoryB));
//            add(new Book("Book B3", categoryB));
//        }};
//        categoryB.setBooks(bookBs);
//
//        bookCategoryRepository.saveAll(new HashSet<BookCategory>() {{
//            add(categoryA);
//            add(categoryB);
//        }});
//
//        // fetch all categories
//        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
//            logger.info(bookCategory.toString());
//        }
    }

}
