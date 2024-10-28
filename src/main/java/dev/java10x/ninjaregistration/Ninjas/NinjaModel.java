package dev.java10x.ninjaregistration.Ninjas;

import jakarta.persistence.*;

import java.util.List;

// Entity transform a Class into a database entity.
// JPA = Java Persistence API
@Entity
@Table(name = "tb_ninja_registration")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    // @ManyToOne -> Many Ninjas to One Mission
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreign Key
    private MissionsModel missions;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
