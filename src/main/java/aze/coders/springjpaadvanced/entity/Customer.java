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
@NamedEntityGraph(name = "customer.accounts", attributeNodes = @NamedAttributeNode("accounts"))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    private String address;

    @OneToOne
    private Identification identification;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Account> accounts;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Work> works;

    public Customer(String name, String address, List<Work> works) {
        this.name = name;
        this.address = address;
        this.works = works;
    }

    public Customer(String name, String address, Identification identification, List<Account> accounts, List<Work> works) {
        this.name = name;
        this.address = address;
        this.identification = identification;
        this.accounts = accounts;
        this.works = works;
    }

    public Customer(String name, String address, Identification identification) {
        this.name = name;
        this.address = address;
        this.identification = identification;
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
