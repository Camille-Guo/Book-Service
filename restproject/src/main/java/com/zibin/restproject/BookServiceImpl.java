package com.zibin.restproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.zibin.restproject.model.Book;

@Service
public class BookServiceImpl implements BookService {

	Map<Long, Book> books = new HashMap<>();
	long currentId = 1001;

	public BookServiceImpl() {
		init();// try to add one simple object manually
	}

	// void method,don't return anything
	void init() {
		Book book = new Book();
		book.setId(currentId);
		book.setTitle("Harry potter");
		books.put(book.getId(), book);
	}

	@Override
	public List<Book> getBooks() {
		Collection<Book> results = books.values();// getting all the values from the map to a local variable
		List<Book> response = new ArrayList<>(results);// Convert to a ArrayList
		return response;// return the ArrayList to user
	}

	@Override
	public Book getBook(Long id) {
		return books.get(id);
	}

	@Override
	public Response createBook(Book book) {
		book.setId(++currentId);
		books.put(book.getId(), book);
		return Response.ok(book).build();
	}

	@Override
	public Response updateBook(Book book) {

		Book currentBook = books.get(book.getId());

		Response response;
		if (currentBook != null) {
			books.put(book.getId(), book);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Response deletetBook(Long id) {

		Book currentBook = books.get(id);

		Response response;
		if (currentBook != null) {
			books.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

}
