package com.spring.bookpart.service;

import com.spring.bookpart.dto.BookDTO;
import com.spring.bookpart.exception.BookException;
import com.spring.bookpart.model.BookModel;
import com.spring.bookpart.model.User;
import com.spring.bookpart.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService
{
    @Autowired
    BookRepository bookRepo;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public BookModel insert(BookDTO bookDTO)
    {
        BookModel book=new BookModel(bookDTO);
        bookRepo.save(book);
        return book;
    }
    @Override
    public List<BookModel> getAllBook()
    {
       User obj = restTemplate.getForObject("http://localhost:8081/homeuser/getById/1", User.class);
        System.out.println(obj.getFirstName());
        List<BookModel> bookList=bookRepo.findAll();
        return bookList;
    }
    @Override
    public Optional<BookModel> getById(Long id){
        Optional<BookModel> book=bookRepo.findById(id);
        if(book.isPresent()){
            return book;
        }else {
            throw new BookException("Cannot Find book id: "+id);
        }
    }
    @Override
    public void deleteById(Long id)
    {
        Optional<BookModel> book=bookRepo.findById(id);
        if(book.isPresent())
        {
            bookRepo.deleteById(id);
        }
        else {
            throw new BookException("Cannot find book id: "+id);
        }
    }
    @Override
    public BookModel searchByBookName(String name)
    {
        BookModel book=bookRepo.findByName(name);
        if(bookRepo.findByName(name)==null)
        {
            throw new BookException("Cannot find book name: "+name);
        }
        else
        {
            return book;
        }
    }
    @Override
    public BookModel updateBookById(BookDTO bookDTO,Long id)
    {
        BookModel book=bookRepo.findById(id).get();
        if(bookRepo.findById(id).isPresent())
        {
            book.setBookName(bookDTO.getBookName());
            book.setAuthorName(bookDTO.getAuthorName());
            book.setBookDescription(book.getBookDescription());
            book.setBookImg(bookDTO.getBookImg());
            book.setPrice(bookDTO.getPrice());
            book.setQuantity(bookDTO.getQuantity());
            bookRepo.save(book);
            return book;
        }
        else
        {
            throw new BookException("Cannot Find id: "+id);
        }
    }
    @Override
    public List<BookModel> sortingAsce()
    {
        List<BookModel> bookList=bookRepo.sortingAsce();
        return bookList;
    }
    @Override
    public List<BookModel> sortingDesc()
    {
        List<BookModel> bookList=bookRepo.sortingDesc();
        return bookList;
    }
    @Override
    public BookModel updateQuantity(BookDTO bookDTO, Long id)
    {
        Optional<BookModel> bookList=bookRepo.findById(id);
        if(bookList.isPresent())
        {
            BookModel book=bookRepo.findById(id).get();
            book.setQuantity(bookDTO.getQuantity());
            bookRepo.save(book);
            return book;
        }
        else
        {
            throw new BookException("Cannot Find id: "+id);
        }
    }
}
