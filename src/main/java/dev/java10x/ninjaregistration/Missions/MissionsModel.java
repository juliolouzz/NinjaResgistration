package dev.java10x.ninjaregistration.Missions;

import dev.java10x.ninjaregistration.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String difficulty;

    // @OneToMany -> One mission to many ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;


}
