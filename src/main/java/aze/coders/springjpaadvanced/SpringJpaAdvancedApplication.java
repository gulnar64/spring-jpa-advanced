package aze.coders.springjpaadvanced;

import aze.coders.springjpaadvanced.repository.AccountRepository;
import aze.coders.springjpaadvanced.repository.CustomerRepository;
import aze.coders.springjpaadvanced.repository.IdentificationRepository;
import aze.coders.springjpaadvanced.repository.WorkRepository;
import aze.coders.springjpaadvanced.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
//@EnableConfigurationProperties(ApplicationConfig.class)
public class SpringJpaAdvancedApplication implements CommandLineRunner {
    private final EntityManagerFactory entityManagerFactory;
    private final CustomerService customerService;
    private final EntityManager entityManager;
    private final CustomerRepository customerRepository;
    private final IdentificationRepository identificationRepository;
    private final AccountRepository accountRepository;
    private final WorkRepository workRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaAdvancedApplication.class, args);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void run(String... args) throws Exception {
//        Identification identification = new Identification(1, "dfdsds", "sds22222");
//        identificationRepository.save(identification);
//        System.out.println(identification.getId());
//        Account account1 = new Account("acc1");
//        Account account2 = new Account("acc2");
//        accountRepository.save(account1);
//        accountRepository.save(account2);
//        Work work1 = new Work("work1");
//        Work work2 = new Work("work2");
//        workRepository.save(work1);
//        workRepository.save(work2);
//        Customer customer = new Customer("ASd", "Doe", identification, List.of(account1, account2), List.of(work1, work2));
//        account1.setCustomer(customer);
//        account2.setCustomer(customer);
//        customerRepository.save(customer);
//        Work work1 = workRepository.findById(1).get();
//        Customer customer = new Customer("ASd", "Doe", List.of(work1));
       // CustomerService customerService = new CustomerServiceImplProxy(customerRepository, entityManagerFactory, entityManager);
        customerService.getAll().forEach(System.out::println);
//        Customer customer = new Customer("ASd 7", "Doe");
//        customerRepository.save(customer);
//        if (1 == 1)
//            throw new Exception();
//        Customer customer1 = new Customer("ASd 8", "Doe");
//        customerRepository.save(customer1);
    }
}
