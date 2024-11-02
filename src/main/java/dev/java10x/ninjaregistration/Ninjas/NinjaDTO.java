package dev.java10x.ninjaregistration.Ninjas;

import dev.java10x.ninjaregistration.Missions.MissionsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private String rank;
    private int age;
    private MissionsModel missions;

}
