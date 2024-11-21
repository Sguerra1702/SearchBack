package edu.eci.cvds.SearchLibrary.Repository;

import edu.eci.cvds.SearchLibrary.Model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SearchRepository extends MongoRepository<Search, Long>{
    List<Search> findByTitleContaining(String title);
    List<Search> findByAuthorContaining(String author);
    List<Search> findBycategoryContaining(String category);
}




