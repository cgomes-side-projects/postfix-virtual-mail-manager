package com.pvmm.emails.domains;

import com.pvmm.emails.email.Email;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresas_tb")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "empresa_id")
    private long id;

    @Column(name = "empresa_site")
    private String domain;

    @Column(name = "empresa_ativo")
    private Boolean active;

    @Column(name = "empresa_datacad")
    private String dateCreated;

    @Column(name = "empresa_codigo")
    private String code;

    @Column(name = "empresa_quota_kb")
    private long quota;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = true)
    private List<Email> emails;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public List<Email> getEmails() {
        return emails;
    }
}
