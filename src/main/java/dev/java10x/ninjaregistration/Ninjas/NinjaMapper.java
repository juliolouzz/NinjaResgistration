package dev.java10x.ninjaregistration.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setMissions(ninjaDTO.getMissions());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setMissions(ninjaModel.getMissions());

        return ninjaDTO;
    }

}
