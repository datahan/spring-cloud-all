package com.datahan.server.harbour.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
