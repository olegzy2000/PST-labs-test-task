package com.webLibrary.library.controller;

import com.webLibrary.library.models.Book;
import com.webLibrary.library.repositori.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class LibraryController {
    @Autowired
    private  BookRepository bookRepository;

    @GetMapping("/library")
    public String libraryMain(Model model){
        Iterable<Book>books=bookRepository.findAll();
            model.addAttribute("books",books);
        return "library-main";
    }
    @GetMapping("/library/add")
    public String addBook(Model model){
        return "add";
    }
    @PostMapping("/library/add")
    public String postAddBook(@RequestParam String title,
                              @RequestParam String nameOfAuthor,
                              @RequestParam String discription,
                              @RequestParam String genre,
                              Model model){

      //Book book=new Book(title,nameOfAuthor,discription);
      //bookRepository.save(book);
      return "redirect:/library";
}
    @GetMapping("/library/{id}")
    public String bookDiscription(@PathVariable(value = "id") long id, Model model){
       if(!bookRepository.existsById(id))
           return "redirect:/";
        Optional<Book> book=bookRepository.findById(id);
        ArrayList<Book>list=new ArrayList<Book>();
        book.ifPresent(list::add);
        model.addAttribute("book",list);
        return "library-details";
    }
    @GetMapping("/library/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") long id, Model model){
        if(!bookRepository.existsById(id))
            return "redirect:/";
        Optional<Book> book=bookRepository.findById(id);
        ArrayList<Book>list=new ArrayList<Book>();
        book.ifPresent(list::add);
        model.addAttribute("book",list);
        return "library-edit";
    }
    @PostMapping("/library/{id}/edit")
    public String postUpdateBook(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                              @RequestParam String nameOfAuthor,
                              @RequestParam String discription,
                              @RequestParam String genre,
                              Model model){
        Book book=bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setNameOfAutor(nameOfAuthor);
        book.setDiscription(discription);
        return "redirect:/library";
    }
    @PostMapping("/library/{id}/remove")
    public String postDeleteBook(@PathVariable(value = "id") long id,
                                 Model model){
        Book book=bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/library";
    }
}
