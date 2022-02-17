package com.wendi.booksAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wendi.booksAPI.models.Book;
import com.wendi.booksAPI.services.BookService;

@RestController
public class BooksApi {
	
	@Autowired
	private BookService bookService;
	
	//ShowALL
	@GetMapping("/api/books")
	public List<Book> showAll(){
		return bookService.allBooks();
	}
	
	//Create
	@PostMapping("/api/books")
	public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
	
	//show one
	@GetMapping("/api/books/{id}")
	public Book showOne(@PathVariable("id")Long id) {
		return bookService.findBook(id);
	}
	
	//update
	@PutMapping("/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.findBook(id);
        book.setTitle(title);
        book.setDescription(desc);
        book.setLanguage(lang);
        book.setNumberOfPages(numOfPages);
        
        return bookService.updateBook(book);
    }
	
	//delete one
	@DeleteMapping("/api/books/{id}")
	public void deleteOne(@PathVariable("id")Long id) {
		bookService.deleteBook(id);
	}
	


}
