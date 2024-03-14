package co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.dataAccessLayer.models.BatteryEntity;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.dataAccessLayer.repositories.IBatteryRepository;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.DTO.BatteryDTO;

@Service
public class BatteryServiceImpl implements IBatteryService {

    @Autowired
    private IBatteryRepository serviceAccessData;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BatteryDTO> findAll() {
        List<BatteryDTO> batteriesDTO = this.modelMapper.map(this.serviceAccessData.findAll(), new TypeToken<List<BatteryDTO>>(){
        }.getType());
        return batteriesDTO;
    }

    @Override
    public BatteryDTO findById(Long id) {
        BatteryDTO batteryDTO = null;
        BatteryEntity batteryEntity = this.serviceAccessData.findById(id);
        if(batteryEntity != null) {
            batteryDTO = this.modelMapper.map(batteryEntity, BatteryDTO.class);
        }
        return batteryDTO;
    }

    @Override
    public BatteryDTO save(BatteryDTO battery) {
        BatteryDTO batteryDTO = null;
        BatteryEntity batteryEntity = this.modelMapper.map(battery, BatteryEntity.class);
        batteryEntity = this.serviceAccessData.save(batteryEntity);
        if(batteryEntity != null) {
            batteryDTO = this.modelMapper.map(batteryEntity, BatteryDTO.class);
        }
        return batteryDTO;
    }

    @Override
    public BatteryDTO update(Long id, BatteryDTO battery) {
        BatteryEntity batteryEntity = this.modelMapper.map(battery, BatteryEntity.class);
        batteryEntity = this.serviceAccessData.update(id, batteryEntity);
        if(batteryEntity != null) {
            return this.modelMapper.map(batteryEntity, BatteryDTO.class);
        }
        else {
            return null;
        }
    }  

    @Override
    public Boolean delete(Long id) {
        return this.serviceAccessData.delete(id);
    }
}
