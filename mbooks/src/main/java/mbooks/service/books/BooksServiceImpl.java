package mbooks.service.books;


import mbooks.model.books.Books;
import mbooks.repository.book.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService {

    @Autowired
    private IBooksRepository bookRepository;

    public List<Books> findAll(){
        return bookRepository.findAll();
    }

    public void  save(Books book){
        bookRepository.save( book );
    }
}
