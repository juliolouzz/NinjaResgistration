package dev.java10x.ninjaregistration.Missions;

import dev.java10x.ninjaregistration.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missions")
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;

    // @OneToMany -> One mission to many ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

    public MissionsModel() {

    }

    public MissionsModel(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
