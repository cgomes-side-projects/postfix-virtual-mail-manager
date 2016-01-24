package com.pvmm.emails.email;

import com.pvmm.domains.domain.Domain;

import javax.persistence.*;

@Entity
@Table(name = "virtual_users")
public class Email {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int    id;

    private String  email;
    private String  password;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "domain_id", nullable = true)
    public Domain domain;


    protected Email() {}


    public Email(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format(
            "Email[id=%d, user='%s', password='%s']",
            id, email, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
