package com.pvmm.aliases.alias;

import com.pvmm.domains.domain.Domain;

import javax.persistence.*;

@Entity
@Table(name = "virtual_aliases")
public class Alias {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int    id;

    private String source;
    private String destination;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "domain_id", nullable = true)
    public Domain domain;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
