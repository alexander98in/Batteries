package co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDTO {

    private Long id;
    private Long documentNumber;
    private String fullName;
    private String gender;
    private Date birthdate;
    private String civilStatus;
    private String city;
    private String educationLevel;
    private String profession;

    public ProfessorDTO() {
    }
}
