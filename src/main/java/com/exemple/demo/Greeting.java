package com.exemple.demo;
public class Greeting {

    private final long id;
    private final String prenom;
    private final String nom;
    private final String mdp;
    private final String mail;

    public Greeting(long id, String prenom, String nom, String mdp, String mail) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.mdp = mdp;
        this.mail= mail;
    }

    public long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

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
