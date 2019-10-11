package mbooks.service.lending;



import mbooks.model.lending.Lending;

import java.util.List;

public interface ILendingService {

    List<Lending> findAll();
    void save(Lending lending);
}
