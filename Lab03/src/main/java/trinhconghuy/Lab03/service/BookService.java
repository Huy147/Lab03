package trinhconghuy.Lab03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinhconghuy.Lab03.entity.Book;
import trinhconghuy.Lab03.repository.IBookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void save(Book product) {
        bookRepository.save(product);
    }

    public Book get(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}