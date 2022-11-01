package com.kawahedukasi.batch4.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    //UUID
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @Column(name = "email")
    public String email;

    @Column(name = "phoneNumber")
    public String phoneNumber;
}
