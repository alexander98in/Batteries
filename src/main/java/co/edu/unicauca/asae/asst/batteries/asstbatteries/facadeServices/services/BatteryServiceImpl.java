package co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.DTO.BatteryDTO;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models.BatteryEntity;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.repositories.IBatteryRepository;

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
        BatteryEntity batteryEntity = this.modelMapper.map(battery, BatteryEntity.class);
        BatteryDTO batteryDTO = this.modelMapper.map(this.serviceAccessData.save(batteryEntity), BatteryDTO.class);
        return batteryDTO;
    }

    @Override
    public BatteryDTO update(Long id, BatteryDTO battery) {
        BatteryEntity batteryEntity = this.modelMapper.map(battery, BatteryEntity.class);
        BatteryDTO batteryDTO = this.modelMapper.map(this.serviceAccessData.update(id, batteryEntity), BatteryDTO.class);
        return batteryDTO;
    }

    @Override
    public Boolean delete(Long id) {
        return this.serviceAccessData.delete(id);
    }

}
