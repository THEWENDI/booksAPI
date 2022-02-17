package com.wendi.booksAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wendi.booksAPI.models.Book;
import com.wendi.booksAPI.services.BookService;

@Controller
public class Homecontroller {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
		
	}
	
	@GetMapping("/books/{id}")
	public String showone(@PathVariable("id")Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
	

}
