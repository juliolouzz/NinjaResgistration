package dev.java10x.ninjaregistration.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
public class MissionsController {

    @GetMapping("/list")
    public String listMissions() {
        return "Showing missions";
    }

    @PostMapping("/create")
    public String createMission(){
        return "Mission created";
    }

    @PutMapping("/alter")
    public String alterMission(){
        return "Mission altered";
    }

    @DeleteMapping("delete")
    public String deleteMission(){
        return "Mission deleted";
    }


}
