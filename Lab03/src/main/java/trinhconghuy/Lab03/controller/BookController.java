package trinhconghuy.Lab03.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trinhconghuy.Lab03.entity.Book;
import trinhconghuy.Lab03.service.BookService;
import trinhconghuy.Lab03.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, @org.jetbrains.annotations.NotNull BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }

        bookService.addBook(book);
        return "redirect:/books";
    }
//
//    @GetMapping({"/edit/{id}"})
//    public String EditForm(@PathVariable("id") Long id, Model model) {
//        Optional<Book> editBook = this.books.stream().filter((book) -> {
//            return book.getId() == id;
//        }).findFirst();
//        if (editBook.isPresent()) {
//            model.addAttribute("book", editBook.get());
//            return "book/edit";
//        } else {
//            return "not found";
//        }
//    }
//
//    @PostMapping({"/edit"})
//    public String EditBook(@ModelAttribute("book") Book updatedBook) {
//        this.books.stream().filter((book) -> {
//            return book.getId() == updatedBook.getId();
//        }).findFirst().ifPresent((book) -> {
//            this.books.set(this.books.indexOf(book), updatedBook);
//        });
//        return "redirect:/books";
//    }
//
  /*  @GetMapping({"/delete/{id}"})
    public String DeleteBook(@PathVariable("id") Long id) {
        this.books.removeIf((book) -> {
           return book.getId() == id;
        });
        return "redirect:/books";
    }*/
}