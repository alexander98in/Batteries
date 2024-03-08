package co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BatteryDTO {

    private Long id;
    private Date date;
    private Boolean authorization;
    private ProfessorDTO professor;
    private List<QuestionDTO> questionsList;

    public BatteryDTO() {
    }
}
