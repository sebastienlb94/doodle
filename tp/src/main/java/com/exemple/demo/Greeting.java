package com.exemple.demo;
public class Greeting {

    private final long id;
    private final String user;
    private final String nom;
    private final String mdp;
    private final String mail;

    public Greeting(long id, String user, String nom, String mdp, String mail) {
        this.id = id;
        this.user = user;
        this.nom = nom;
        this.mdp = mdp;
        this.mail= mail;
    }

    public long getId() {
        return id;
    }

    public String getUser() { return user; }

    public String getNom(){
        return nom;
    }

    public String getMdp(){
        return mdp;
    }

    public String getMail(){
        return mail;
    }
}
