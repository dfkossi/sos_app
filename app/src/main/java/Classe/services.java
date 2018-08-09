package Classe;

public class services {
    String name;
    String pays;
    Integer number;
    String Email;

    public services(){

    }

    public services(String name, Integer number, String email) {
        this.name = name;
        this.pays=pays;
        this.number = number;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public String getPays() {
        return pays;
    }

    public Integer getNumber() {
        return number;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "services{" + "Name:'" + name + "\n ,Pays:'" + pays +"\n, Number:" + number + "\n, Email:'" + Email +"\n"+ '}';
    }
}
