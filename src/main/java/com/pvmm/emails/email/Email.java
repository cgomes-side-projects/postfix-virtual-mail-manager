package com.pvmm.emails.email;

import javax.persistence.*;

@Entity
@Table(name = "users_tb")
public class Email {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_users")
    private long    id;

    @Column(name="email_users")
    private String  email;

    @Column(name="password_users")
    private String  password;

    @Column(name="quota_users")
    private long    quota;

    @Column(name="datacad_users")
    private String  dateCreated;

    @Column(name="salvo_users")
    private boolean salvo;

    @Column(name="ativo_users")
    private boolean ativo;


    protected Email() {}


    public Email(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format(
            "Email[id=%d, user='%s', password='%s', dataCad='%s', salvo=%b, ativo=%b]",
            id, email, password, dateCreated, salvo, ativo);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isSalvo() {
        return salvo;
    }

    public void setSalvo(boolean salvo) {
        this.salvo = salvo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getAtivo() {
        return ativo ? "Sim" : "Não";
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
