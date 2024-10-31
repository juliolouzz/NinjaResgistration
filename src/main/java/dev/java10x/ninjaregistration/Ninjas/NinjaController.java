package dev.java10x.ninjaregistration.Ninjas;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to Ninja Registration";
    }

    // Add Ninja (CREATE)
    @PostMapping("/create")
    public String createNinja() {
        return "Ninja Created";
    }

    // Show All Ninjas (READ)
    @GetMapping("/list")
    public List<NinjaModel> showAllNinjas() {
        return ninjaService.showAllNinjas();
    }

    // Show Ninjas by ID (READ)
    @GetMapping("/list/{id}")
    public NinjaModel showAllNinjasByID(@PathVariable Long id) {
        return ninjaService.showAllNinjasByID(id);
    }

    // Alter Ninja data (UPDATE)
    @PutMapping("/alterID")
    public String alterNinjaByID() {
        return "Ninja Altered";
    }

    // Delete Ninja (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteNinjaByID() {
        return "Ninja Deleted";
    }


}
