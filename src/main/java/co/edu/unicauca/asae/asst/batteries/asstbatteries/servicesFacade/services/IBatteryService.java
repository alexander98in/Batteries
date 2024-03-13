package co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.services;

import java.util.List;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.DTO.BatteryDTO;

public interface IBatteryService {

    public List<BatteryDTO> findAll();
    public BatteryDTO findById(Long id);
    public BatteryDTO save(BatteryDTO battery);
    public BatteryDTO update(Long id, BatteryDTO battery);
    public Boolean delete(Long id);

}
