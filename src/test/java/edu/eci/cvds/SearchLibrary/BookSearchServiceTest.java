package edu.eci.cvds.SearchLibrary;

import edu.eci.cvds.SearchLibrary.Model.Search;
import edu.eci.cvds.SearchLibrary.Repository.SearchRepository;
import edu.eci.cvds.SearchLibrary.Service.BookSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookSearchServiceTest {

    @MockBean
    private SearchRepository searchRepository;

    @Autowired
    private BookSearchService bookSearchService;

    private List<Search> books;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        books= Arrays.asList(
                new Search("Effective Java", "Joshua Bloch", "Programming"),
                new Search("Java Concurrency", "Brian Goetz", "Programming"),
                new Search("Clean Code", "Robert C. Martin", "Programming"),
                new Search("Introduction to Algorithms", "Thomas H. Cormen", "Computer Science"),
                new Search("Design Patterns", "Erich Gamma", "Programming"),
                new Search("The Pragmatic Programmer", "Andy Hunt", "Programming")
        );

        when(searchRepository.findAll()).thenReturn(books);
        when(searchRepository.findByTitleContaining("Java")).thenReturn(
                Arrays.asList(books.get(0), books.get(1))
        );
        when(searchRepository.findByAuthorContaining("Martin")).thenReturn(
                Arrays.asList(books.get(2))
        );
        when(searchRepository.findBycategoryContaining("Computer Science")).thenReturn(
                Arrays.asList(books.get(3))
        );
    }

    @Test
    public void testSearchBooksByTitle() {
        List<Search> result = bookSearchService.SearchBooks("Java", null, null);
        assertEquals(2, result.size());
        verify(searchRepository, times(1)).findByTitleContaining("Java");
    }
    
    @Test
    public void testSearchBooksByAuthor() {
        List<Search> result = bookSearchService.SearchBooks(null, "Martin", null);
        assertEquals(1, result.size());
        verify(searchRepository, times(1)).findByAuthorContaining("Martin");
    }

    @Test
    public void testSearchBooksByCategory() {
        List<Search> result = bookSearchService.SearchBooks(null, null, "Computer Science");
        assertEquals(1, result.size());
        verify(searchRepository, times(1)).findBycategoryContaining("Computer Science");
    }

    @Test
    public void testSearchBooksWithoutFilters() {
        List<Search> result = bookSearchService.SearchBooks(null, null, null);
        assertEquals(6, result.size());
        verify(searchRepository, times(1)).findAll();
    }

}
