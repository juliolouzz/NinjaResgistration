package dev.java10x.ninjaregistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List all ninjas
    public List<NinjaDTO> showAllNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // List all ninjas by ID
    public NinjaDTO showAllNinjasByID(Long id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    // Create a new Ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Delete a Ninja - need to be void method
    public void deleteNinjaByID(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Alter/Update Ninja data
    public NinjaDTO alterNinjaByID(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);
        if (ninjaExist.isPresent()) {
            NinjaModel ninjaAltered = ninjaMapper.map(ninjaDTO);
            ninjaAltered.setId(id);
            NinjaModel updatedNinja = ninjaRepository.save(ninjaAltered);
            return ninjaMapper.map(updatedNinja);
        }
        return null;
    }


}
