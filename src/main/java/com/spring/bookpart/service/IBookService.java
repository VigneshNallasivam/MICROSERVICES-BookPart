package com.spring.bookpart.service;

import com.spring.bookpart.dto.BookDTO;
import com.spring.bookpart.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface IBookService
{
    BookModel insert(BookDTO bookDTO);

    List<BookModel> getAllBook();

    Optional<BookModel> getById(Long id);

    void deleteById(Long id);

    BookModel searchByBookName(String name);

    BookModel updateBookById(BookDTO bookDTO, Long id);

    List<BookModel> sortingAsce();

    List<BookModel> sortingDesc();

    BookModel updateQuantity(BookDTO bookDTO, Long id);
}
