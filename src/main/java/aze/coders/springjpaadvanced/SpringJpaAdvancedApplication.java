package aze.coders.springjpaadvanced;

import aze.coders.springjpaadvanced.config.ApplicationConfig;
import aze.coders.springjpaadvanced.entity.Account;
import aze.coders.springjpaadvanced.entity.Customer;
import aze.coders.springjpaadvanced.entity.Identification;
import aze.coders.springjpaadvanced.model.CustomerDto;
import aze.coders.springjpaadvanced.repository.CustomerRepository;
import aze.coders.springjpaadvanced.repository.IdentificationRepository;
import aze.coders.springjpaadvanced.service.CustomerService;
import jakarta.transaction.Transactional;
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
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final IdentificationRepository identificationRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Identification identification = new Identification("dfdsds", "sds22222");
        Account account1 = new Account("acc1");
        Account account2 = new Account("acc2");
        Customer customer = new Customer("ASd", "Doe", identification, List.of(account1, account2));
        account1.setCustomer(customer);
        account2.setCustomer(customer);
        customerRepository.save(customer);
    }
}
