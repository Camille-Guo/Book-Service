package com.zibin.restproject;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.zibin.restproject.model.Book;

@Path("/bookservice")
public interface BookService {

	@Path("/books") // URI
	@GET // HTTP method
	List<Book> getBooks();

	@Path("/books/{id}")
	@GET
	Book getBook(@PathParam("id") Long id);

	@Path("/books")
	@POST
	Response createBook(Book book);

	@Path("/books")
	@PUT
	Response updateBook(Book book);

	@Path("/books/{id}")
	@DELETE
	Response deletetBook(@PathParam("id") Long id);

}
