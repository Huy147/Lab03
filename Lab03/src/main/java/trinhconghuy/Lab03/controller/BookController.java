package trinhconghuy.Lab03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trinhconghuy.Lab03.entity.Book;
import trinhconghuy.Lab03.service.BookService;
import trinhconghuy.Lab03.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/books"})
public class BookController {
    //    @Autowired
//    private List<Book> books;
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    public BookController() {
    }

    @GetMapping
    public String showAllBook(Model model) {
        List<Book> listBook = bookService.getAll();
        model.addAttribute("books", listBook);
        return "book/list";
    }
    //    @GetMapping
//    public String ListBooks(Model model) {
//        model.addAttribute("books", this.books);
//        model.addAttribute("title", "Book List");
//        return "book/list";
//    }
//
    @GetMapping({"/add"})
    public String AddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.listAll());
        return "book/add";
    }

    @PostMapping({"/add"})
    public String AddBook(@ModelAttribute("book") Book book) {
        this.bookService.save(book);
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
//    @GetMapping({"/delete/{id}"})
//    public String DeleteBook(@PathVariable("id") Long id) {
//        this.books.removeIf((book) -> {
//            return book.getId() == id;
//        });
//        return "redirect:/books";
//    }
}