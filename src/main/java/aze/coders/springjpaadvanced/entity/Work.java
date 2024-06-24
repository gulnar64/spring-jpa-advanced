package aze.coders.springjpaadvanced.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Table(name = "Works")
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
public class Work { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

    private String work;

    public Work(String work) {
        this.work = work;
    }
}
