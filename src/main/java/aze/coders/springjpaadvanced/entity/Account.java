package aze.coders.springjpaadvanced.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Accounts")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String accountNumber;
    @ManyToOne
    private Customer customer;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
