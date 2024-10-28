package dev.java10x.ninjaregistration.Ninjas;

import dev.java10x.ninjaregistration.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity transform a Class into a database entity.
// JPA = Java Persistence API
@Entity
@Table(name = "tb_ninja_registration")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "age")
    private int age;

    // @ManyToOne -> Many Ninjas to One Mission
    @ManyToOne
    @JoinColumn(name = "missions_id") // Foreign Key
    private MissionsModel missions;


}
