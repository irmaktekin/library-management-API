package patika.dev.api.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
        @Bean
        public ModelMapper getModelMapper(){
            return new ModelMapper();
        }

}
