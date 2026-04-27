package com.sci.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "employees")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data                   // Lombok: getters + setters + toString
@NoArgsConstructor     // Lombok: default constructor
@AllArgsConstructor    // Lombok: all-args constructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emp_seq")
    @SequenceGenerator(
            name         = "emp_seq",
            sequenceName = "employees_seq",
            allocationSize = 1)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;
}
