package dev.java10x.ninjaregistration.Ninjas;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
    @GetMapping("/All")
    public String showAllNinjas() {
        return "Show Ninjas";
    }

    // Show Ninjas by ID (READ)
    @GetMapping("/allID")
    public String showAllNinjasByID() {
        return "Show Ninjas By ID";
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
