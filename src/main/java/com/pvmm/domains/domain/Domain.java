package com.pvmm.domains.domain;

import com.pvmm.emails.email.Email;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "virtual_domains")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(insertable = false, updatable = false)
    private Integer id = 0;


    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = true)
    public List<Email> emails;


    @Override
    public String toString() {
        return String.format(
            "Domain[id=%d, name='%s']",
            id, name);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
