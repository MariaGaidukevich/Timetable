package com.example.demo.model;

import com.example.demo.enums.Subjects;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String middlename;
    @Enumerated(EnumType.STRING)
    private Subjects subject;
    @Column(unique=true)
    private String passCard;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Grade> grades;
}
