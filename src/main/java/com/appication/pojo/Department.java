package com.appication.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
