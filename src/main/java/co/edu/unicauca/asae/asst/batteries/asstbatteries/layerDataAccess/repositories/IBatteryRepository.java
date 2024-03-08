package co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.repositories;

import java.util.List;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models.BatteryEntity;

public interface IBatteryRepository {

    public List<BatteryEntity> findAll();
    public BatteryEntity findById(Long id);
    public BatteryEntity save(BatteryEntity battery);
    public BatteryEntity update(Long id, BatteryEntity battery);
    public Boolean delete(Long id);

}
