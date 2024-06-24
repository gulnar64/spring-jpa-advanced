package aze.coders.springjpaadvanced.model;

import aze.coders.springjpaadvanced.entity.Account;
import aze.coders.springjpaadvanced.entity.Identification;
import aze.coders.springjpaadvanced.entity.Work;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private String address;
    private Identification identification;
    private List<Account> accounts;
    private List<Work> works;
}
