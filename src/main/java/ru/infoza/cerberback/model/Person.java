package ru.infoza.cerberback.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "persons")
public class Person {

    @Id
    private Long id;

    private String surname;
    private String name;
    private String patronymic;
    private LocalDate born;
}
