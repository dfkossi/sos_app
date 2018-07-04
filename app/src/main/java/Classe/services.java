package Classe;

public class services {
    String name;
    Integer number;
    String Email;

    public services(){

    }

    public services(String name, Integer number, String email) {
        this.name = name;
        this.number = number;
        Email = email;
    }

    public String getName() {
        return name;
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

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "services{" + "name:'" + name + '\'' + ", number:" + number + ", Email:'" + Email + '\'' + '}';
    }
}
