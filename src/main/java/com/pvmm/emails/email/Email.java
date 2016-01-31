package com.pvmm.emails.email;

import com.pvmm.domains.domain.Domain;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

@Entity
@Table(name = "virtual_users")
public class Email {

    @Id
    @Column(nullable=true, unique=true, insertable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int    id;

    @Column(nullable = false)
    private String  email;

    @Column(nullable = false)
    private String  password;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    public Domain domain = new Domain();


    public Email() {}


    public Email(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format(
            "Email[id=%d, email='%s', password='%s', domainId: %d, domainName: '%s']",
            id, email, password,  domain.getId(), domain.getName());
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

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }



}
