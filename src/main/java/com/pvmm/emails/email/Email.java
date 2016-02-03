package com.pvmm.emails.email;

import com.pvmm.domains.domain.Domain;
import com.pvmm.utils.cruds.CrudEntityInterface;

import javax.persistence.*;

@Entity
@Table(name = "virtual_users")
public class Email implements CrudEntityInterface {

    @Id
    @Column(nullable=true, unique=true, insertable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int    id;

    @Column(nullable = false)
    private String  email;

    @Column(nullable = false)
    private String  password;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name = "domain_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Domain domain;


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
        if( domain == null ) {
            domain = new Domain();
        }

        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }



}
