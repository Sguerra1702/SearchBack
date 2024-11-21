package edu.eci.cvds.SearchLibrary.Service;

import java.util.Optional;
import edu.eci.cvds.SearchLibrary.Repository.SearchRepository;
import edu.eci.cvds.SearchLibrary.Model.Search;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookSearchService {

    private final SearchRepository searchRepository;

    public BookSearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Search> SearchBooks(String title, String author, String category) {
        if (title != null && !title.isEmpty()) {
            return searchRepository.findByTitleContaining(title);
        } else if (author != null && !author.isEmpty()) {
            return searchRepository.findByAuthorContaining(author);
        } else if (category != null && !category.isEmpty()) {
            return searchRepository.findBycategoryContaining(category);
        }
        return searchRepository.findAll();
    }

    public String consultarEstado(Long  bookID) {
        Optional<Search> optionalSearch = searchRepository.findById(bookID);
        if (optionalSearch.isPresent()) {
            return optionalSearch.get().getState();
        } else {
            throw new RuntimeException("Libro no encontrado con ID: " + bookID);
        }
    }

}
