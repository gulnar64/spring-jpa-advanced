package aze.coders.springjpaadvanced.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Entity
@Data
@Table(name = "customers")
@FieldNameConstants
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Identification identification;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Customer(String name, String address, Identification identification, List<Account> accounts) {
        this.name = name;
        this.address = address;
        this.identification = identification;
        this.accounts = accounts;
    }
}
