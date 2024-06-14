package aze.coders.springjpaadvanced.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Table(name="customers")
@FieldNameConstants
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    private String address;
}
