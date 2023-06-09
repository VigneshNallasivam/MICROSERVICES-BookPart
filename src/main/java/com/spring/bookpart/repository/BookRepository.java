package com.spring.bookpart.repository;

import com.spring.bookpart.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Long>
{
    @Query(value = "select * from books.book where book.book_name= :name",nativeQuery = true)
    BookModel findByName(String name);
    @Query(value = "select * from books.book ORDER BY price ASC",nativeQuery = true)
    List<BookModel> sortingAsce();
    @Query(value = "select * from books.book ORDER BY price DESC",nativeQuery = true)
    List<BookModel> sortingDesc();
}

