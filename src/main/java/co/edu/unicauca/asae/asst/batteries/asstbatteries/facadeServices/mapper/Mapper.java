package co.edu.unicauca.asae.asst.batteries.asstbatteries.facadeServices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
