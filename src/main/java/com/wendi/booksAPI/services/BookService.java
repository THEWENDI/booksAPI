package com.wendi.booksAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wendi.booksAPI.models.Book;
import com.wendi.booksAPI.repositories.BookRepository;

@Service
public class BookService {
	
	//Option 1
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    //Option 2
//    @Autowired
//    private BookRepository bookRepository;
    
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //update
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
    
    //delete
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

}
