package co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorEntity {

    private Long id;
    private Long documentNumber;
    private String fullName;
    private String gender;
    private Date birthdate;
    private String civilStatus;
    private String city;
    private String educationLevel;
    private String profession;

    public ProfessorEntity() {
    }

}
