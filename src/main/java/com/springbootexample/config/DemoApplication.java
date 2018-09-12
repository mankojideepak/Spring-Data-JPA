package com.springbootexample.config;

import com.springbootexample.model.Employee;
import com.springbootexample.model.User;
import com.springbootexample.repository.EmployeeRepository;
import com.springbootexample.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springbootexample.*")
@EntityScan(basePackages = "com.springbootexample.*")
@EnableJpaRepositories(basePackages = {"com.springbootexample.*"})
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @PersistenceContext
    private EntityManager entitymanager;

//    @Autowired
//    private ProductRepository ProductRepository;
//
//    @Autowired
//    private BookCategoryRepository bookCategoryRepository;
//
//    @Autowired
//    private ManufacturerRepository ManufacturerRepository;

    @Autowired
    private EmployeeRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    @Transactional
//    public void run(String... strings) throws Exception {
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
//    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
//        List<Employee> employees = createEmployees();
//        repo.saveAll(employees);

        System.out.println(" -- finding all employees --");
        Iterable<Employee> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println(" -- finding by dept Sales sort by 'salary' and 'name'  --");
        List<Employee> list = repo.findByDept("Sales", Sort.by("salary", "name").ascending());
        list.forEach(System.out::println);


        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root from = criteriaQuery.from(Employee.class);

        //select all records
        System.out.println("Selecting All Records");
        CriteriaQuery select = criteriaQuery.select(from);
        TypedQuery typedQuery = entitymanager.createQuery(select);
        List resultlist = typedQuery.getResultList();

        for(Object o:resultlist) {
            Employee e = (Employee)o;
            System.out.println("EID : " + e.getId() + " Ename : " + e.getName());
        }
        entitymanager.close( );
    }

//    private List<Employee> createEmployees() {
//        return Arrays.asList(
//                Employee.create("Diana", "Sales", 2000),
//                Employee.create("Mike", "Sales", 1000),
//                Employee.create("Rose", "IT", 4000),
//                Employee.create("Sara", "Sales", 3000),
//                Employee.create("Andy", "Sales", 3000),
//                Employee.create("Charlie", "IT", 2500)
//        );
//    }

}
