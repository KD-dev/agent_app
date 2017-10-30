package com.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue
    private String id;


    private String password;
    private String phoneNumber;
    private String address;
    private String token;


}
