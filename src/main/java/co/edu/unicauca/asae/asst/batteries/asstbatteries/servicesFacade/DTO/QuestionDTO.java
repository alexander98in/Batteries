package co.edu.unicauca.asae.asst.batteries.asstbatteries.servicesFacade.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {

    private Long id;
    private String name;
    private Integer value;

    public QuestionDTO() {
    }
}
