package com.springbootexample.config;

import com.springbootexample.model.Book;
import com.springbootexample.model.BookCategory;
import com.springbootexample.model.Employee;
import com.springbootexample.repository.EmployeeRepository;
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
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
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

        System.out.println("\n############### Finding all employees ###############");
        Iterable<Employee> all = repo.findAll();
        all.forEach(System.out::println);

        System.out.println("\n############### Finding by dept Sales sort by 'salary' and 'name' ###############");
        List<Employee> list = repo.findByDept("Sales", Sort.by("salary", "name").ascending());
        list.forEach(System.out::println);


        //######################CRITERIA API########################
        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root emp = criteriaQuery.from(Employee.class);

        System.out.println("\n############### eg1-Selecting All Records ###############");
        CriteriaQuery select1 = criteriaQuery.select(emp);
        runTypedQuery(select1);


        System.out.println("\n############### eg2-Selecting All Records with Dept = sales ###############");
        Predicate cond = criteriaBuilder.equal(emp.get("dept"), "Sales");
        CriteriaQuery select2 = criteriaQuery.select(emp).where(cond);
        runTypedQuery(select2);

        System.out.println("\n############### eg3-Selecting All Records with 75<=ID<=78 ###############");
        Predicate cond1 = criteriaBuilder.greaterThanOrEqualTo(emp.get("id"), 75);
        Predicate cond2 = criteriaBuilder.lessThanOrEqualTo(emp.get("id"), 78);
        CriteriaQuery select3 = criteriaQuery.select(emp).where(cond1, cond2);
        runTypedQuery(select3);

        System.out.println("\n############### eg4-Using GroupBy and HavingGroupBy ###############");
        criteriaQuery = criteriaBuilder.createQuery();
        emp = criteriaQuery.from(Employee.class);
        CriteriaQuery multiSelect1 = criteriaQuery.multiselect(emp.get("dept"), criteriaBuilder.sum(emp.get("salary"))).groupBy(emp.get("dept"));
        runTypedQuery(multiSelect1, true);

        System.out.println("\n############### eg5-Using GroupBy and Having ###############");
        criteriaQuery = criteriaBuilder.createQuery();
        emp = criteriaQuery.from(Employee.class);
        CriteriaQuery multiSelect2 = criteriaQuery.multiselect(emp.get("dept"), criteriaBuilder.sum(emp.get("salary"))).groupBy(emp.get("dept")).having(criteriaBuilder.gt(criteriaBuilder.sum(emp.get("salary")), 6500));
        runTypedQuery(multiSelect2, true);

        System.out.println("\n############### eg6-Using OrderBy ###############");
        criteriaQuery = criteriaBuilder.createQuery();
        CriteriaQuery select4 = criteriaQuery.select(criteriaQuery.from(Employee.class)).orderBy(criteriaBuilder.asc(emp.get("dept")), criteriaBuilder.desc(emp.get("salary")));
        runTypedQuery(select4);

        //###################### NAMED QUERIES ########################
        System.out.println("\n############### eg1-findEmployeeNameByid ###############");
        TypedQuery tQry = entitymanager.createNamedQuery("findEmployeeNameByid", Employee.class);
        for (Object o : tQry.getResultList()) {
            Employee e = (Employee) o;
            System.out.println("EID : " + e.getId() + ", Ename : " + e.getName() + ", Dept : " + e.getDept() + ", Salary : " + e.getSalary());
        }

        System.out.println();
        entitymanager.close();
    }


    private void runTypedQuery(CriteriaQuery cq) {
        TypedQuery<Object> tq = entitymanager.createQuery(cq);
        for (Object o : tq.getResultList()) {
            Employee e = (Employee) o;
            System.out.println("EID : " + e.getId() + ", Ename : " + e.getName() + ", Dept : " + e.getDept() + ", Salary : " + e.getSalary());
        }
    }

    private void runTypedQuery(CriteriaQuery cq, boolean flag) {
        TypedQuery<Object[]> tq = entitymanager.createQuery(cq);
        for (Object[] object : tq.getResultList()) {
            System.out.println(object[0] + " : " + object[1]);
        }
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
