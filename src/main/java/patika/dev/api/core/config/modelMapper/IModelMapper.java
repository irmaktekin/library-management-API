package patika.dev.api.core.config.modelMapper;


import org.modelmapper.ModelMapper;

public interface IModelMapper {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
