package aze.coders.springjpaadvanced.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Table(name="Identifications")
@NoArgsConstructor
@AllArgsConstructor
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String finCode;
    private String serialNumber;

    public Identification(String finCode, String serialNumber) {
        this.finCode = finCode;
        this.serialNumber = serialNumber;
    }
}
