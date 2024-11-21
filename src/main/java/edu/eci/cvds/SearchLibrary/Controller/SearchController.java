package edu.eci.cvds.SearchLibrary.Controller;

import edu.eci.cvds.SearchLibrary.Model.Search;

import edu.eci.cvds.SearchLibrary.Service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final BookSearchService bookSearchService;

    @Autowired
    public SearchController(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    @GetMapping("/books")
    public List<Search> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category) {
        return bookSearchService.SearchBooks(title, author, category);
    }

    @GetMapping("/books/{id}/estado")
    public String consultarEstado(@PathVariable Long  id) {
        try {
            return bookSearchService.consultarEstado(id);
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }


}
