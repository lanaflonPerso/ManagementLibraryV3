package mbooks.service.edition;

import mbooks.model.Edition;

import java.util.List;

public interface IEditionService {

    List<Edition> list();
    Edition find(Long id);
    Edition save(Edition edition);

    boolean delete(Long id);
}
