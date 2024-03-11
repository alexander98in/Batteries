package co.edu.unicauca.asae.asst.batteries.asstbatteries.layerControllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.DTO.BatteryDTO;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.services.IBatteryService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class BatteryRestController {

    @Autowired
    private IBatteryService batteryService;

    @GetMapping("/batteries")
    public List<BatteryDTO> index() {
        return this.batteryService.findAll();
    }

    @GetMapping("/battery/{id}")
    public BatteryDTO show(@PathVariable Long id) {
        return this.batteryService.findById(id);
    }

    @PostMapping("path")
    public BatteryDTO create(@RequestBody BatteryDTO battery) {
        return this.batteryService.save(battery);
    }
    
    @PutMapping("/battery/{id}")
    public BatteryDTO update(@PathVariable Long id, @RequestBody BatteryDTO battery) {
        return this.batteryService.update(id, battery);
    }

    @DeleteMapping("battery")
    public Map<String, Object> delete(@RequestParam Long id) {
       
        Map<String, Object> response = new HashMap<>();
        String message = null;
        if(this.batteryService.delete(id)) {
            message = "La bateria con id: " + id +  " se elimino con exito";
        }
        else {
            message = "La bateria ya se encuentra eliminada o no se encuentra registrada con el id: " + id;
        }
        response.put("respuesta", message);
        return response;
    }

}
