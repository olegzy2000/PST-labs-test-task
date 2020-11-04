package com.webLibrary.library.repositori;

import com.webLibrary.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
