package co.edu.unicauca.asae.asst.batteries.asstbatteries.layerDataAccess.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionEntity {

    private Long id;
    private String name;
    private Integer value;

    public QuestionEntity() {
    }
}
