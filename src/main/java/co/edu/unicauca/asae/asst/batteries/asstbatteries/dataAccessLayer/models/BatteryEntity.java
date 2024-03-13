package co.edu.unicauca.asae.asst.batteries.asstbatteries.dataAccessLayer.models;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BatteryEntity {

    private Long id;
    private Date date;
    private Boolean authorization;
    private ProfessorEntity professor;
    private List<QuestionEntity> questionsList;

    public BatteryEntity() {
    }

    @Override
    public String toString() {
        return "BatteryEntity [id=" + id + ", date=" + date + ", authorization=" + authorization + ", professor="
                + professor + ", questionsList=" + questionsList + "]";
    }

    
}
