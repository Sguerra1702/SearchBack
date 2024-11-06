package edu.eci.cvds.SearchLibrary.Controller;

import edu.eci.cvds.SearchLibrary.Model.Search;

import edu.eci.cvds.SearchLibrary.Service.SearchService.BookSearchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("los/libros")
    public class SearchController{

        private final BookSearchService bookSearchService;
        
        public SearchController(BookSearchService bookSearchService){
            this.bookSearchService=bookSearchService;
}

    @GetMapping("/search")
    public List<Search> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category) {
        return bookSearchService.SearchBooks(title, author, category);
    }
    
}
