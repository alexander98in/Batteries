package co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.repositories;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models.BatteryEntity;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models.ProfessorEntity;
import co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models.QuestionEntity;

@Repository
public class BatteryRepositoryImpl implements IBatteryRepository {

    private List<BatteryEntity> batteryList;

    public BatteryRepositoryImpl(List<BatteryEntity> batteryList) {
        this.batteryList = batteryList;
        loadData();
    }

    @Override
    public List<BatteryEntity> findAll() {
        System.out.println("Invocando a listar baterias ahhh");
        return this.batteryList;
    }

    @Override
    public BatteryEntity findById(Long id) {
        System.out.println("Invocando a consultar bateria");
        return this.batteryList.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null); 
    }

    @Override
    public BatteryEntity save(BatteryEntity battery) {
        System.out.println("Invocando a almacenar bateria");
        BatteryEntity newBattery = null;
        if(this.batteryList.add(newBattery)) {
            newBattery = battery;
        }
        return newBattery;
    }

    @Override
    public BatteryEntity update(Long id, BatteryEntity battery) {
        System.out.println("Invocando a actualizar bateria");
        BatteryEntity batteryUpdate = null;
        batteryUpdate = this.batteryList.stream().filter(b -> b.getId().equals(id))
            .map(b -> {
                b.setAuthorization(battery.getAuthorization());
                b.setDate(battery.getDate());
                b.setProfessor(battery.getProfessor());
                b.setQuestionsList(battery.getQuestionsList());
                return b;
            })
            .findFirst().orElse(null);
        return batteryUpdate;
    }

    @Override
    public Boolean delete(Long id) {
        System.out.println("Invocando a eliminar una bateria");

        List<BatteryEntity> listFilter = this.batteryList.stream()
            .filter(b -> !b.getId().equals(id))
            .toList();
        
        if (listFilter.size() < this.batteryList.size()) {
            this.batteryList = listFilter;
            return true;
        }else {
            return false;
        }

    }

    private void loadData() {
        QuestionEntity question1 = new QuestionEntity(1L, "El ruido en el lugar donde trabaja es molesto", 3);
        QuestionEntity question2 = new QuestionEntity(2L, "El aire en el lugar es fresco y agradable", 2);
        QuestionEntity question3 = new QuestionEntity(3L, "El espacio donde trabajo es agradable", 2);
        QuestionEntity question4 = new QuestionEntity(4L, "Es fácil transportarme entre mi casa y el trabajo", 2);
        QuestionEntity question5 = new QuestionEntity(5L, "La zona donde vivo es segura", 2);

        List<QuestionEntity> questionList = Arrays.asList(question1, question2, question3, question4, question5);
        
        DateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date birthdate = new Date();
        ProfessorEntity professor1 = new ProfessorEntity();
        ProfessorEntity professor2 = new ProfessorEntity();
        ProfessorEntity professor3 = new ProfessorEntity();
        ProfessorEntity professor4 = new ProfessorEntity();
        ProfessorEntity professor5 = new ProfessorEntity();
        ProfessorEntity professor6 = new ProfessorEntity();

        try {
            birthdate = sdf.parse("10/01/1998");
            professor1 = new ProfessorEntity(1L, 1061811001L, "Francisco Rodriguez", 
            "M", birthdate, "Casado (a)", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
            birthdate = sdf.parse("12/12/1992");
            professor2 = new ProfessorEntity(1L, 1061811002L, "Alexander Gomez", 
            "M", birthdate, "Unión libre", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
            birthdate = sdf.parse("04/01/1993");
            professor3 = new ProfessorEntity(1L, 1061811003L, "Sara Lopez", 
            "F", birthdate, "Soltero (a)", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
            birthdate = sdf.parse("10/01/2022");
            professor4 = new ProfessorEntity(1L, 1061811004L, "Edwin Lopez", 
            "M", birthdate, "Casado (a)", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
            birthdate = sdf.parse("10/01/2022");
            professor5 = new ProfessorEntity(1L, 1061811005L, "Angelica Pinto", 
            "F", birthdate, "Unión libre", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
            birthdate = sdf.parse("10/01/2022");
            professor6 = new ProfessorEntity(1L, 1061811006L, "Camilo Muñoz", 
            "M", birthdate, "Unión libre", "Popayan", "Profesional Completo", "Ingeniero de Sistemas");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        BatteryEntity battery1 = new BatteryEntity(1L, new Date(), true, professor1, questionList);
        BatteryEntity battery2 = new BatteryEntity(2L, new Date(), true, professor2, questionList);
        BatteryEntity battery3 = new BatteryEntity(3L, new Date(), true, professor3, questionList);
        BatteryEntity battery4 = new BatteryEntity(4L, new Date(), true, professor4, questionList);
        BatteryEntity battery5 = new BatteryEntity(5L, new Date(), true, professor5, questionList);
        BatteryEntity battery6 = new BatteryEntity(6L, new Date(), true, professor6, questionList);

        this.batteryList = Arrays.asList(battery1, battery2, battery3, battery4, battery5, battery6);
    }

}
