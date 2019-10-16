package mbooks.service.books.cover;



import mbooks.model.books.Cover;

import java.util.List;

public interface ICoverService {

    List<Cover> findAll();
    List<Cover> findAll(String coverUse );

    Cover save(Cover cover);
    Cover getCover(Long id );

    boolean delete(Long id);
}
