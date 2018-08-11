package Classe;

public class Perso {
    String nom;
    String prenom;
    char sexe;
    String GS; //Groupe sanguin
    String antMed;
    String nomCPersonContact;
    String numPersonContact;

    public Perso(){

    }

    public Perso(String nom, String prenom, char sexe, String GS, String antMed, String nomCPersonContact, String numPersonContact) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe=sexe;
        this.GS = GS;
        this.antMed = antMed;
        this.nomCPersonContact = nomCPersonContact;
        this.numPersonContact = numPersonContact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getGS() {
        return GS;
    }

    public void setGS(String GS) {
        this.GS = GS;
    }

    public String getAntMed() {
        return antMed;
    }

    public void setAntMed(String antMed) {
        this.antMed = antMed;
    }

    public String getNomCPersonContact() {
        return nomCPersonContact;
    }

    public void setNomCPersonContact(String nomCPersonContact) {
        this.nomCPersonContact = nomCPersonContact;
    }

    public String getNumPersonContact() {
        return numPersonContact;
    }

    public void setNumPersonContact(String numPersonContact) {
        this.numPersonContact = numPersonContact;
    }

    @Override
    public String toString() {
        return "Perso{" + "Prénom:'" + prenom + '\'' + ", Nom:'" + nom + '\'' + ", Groupe Sanguin:'" + GS + '\'' + ", Antecedant Medical:'" + antMed + '\'' + ", Person Responsable:'" + nomCPersonContact + '\'' + ", Phone:'" + numPersonContact + '\'' + '}';
    }
}
