package com.multi.datasource.domain.shop;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
