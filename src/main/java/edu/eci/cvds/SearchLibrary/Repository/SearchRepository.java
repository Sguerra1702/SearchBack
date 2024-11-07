package edu.eci.cvds.SearchLibrary.Repository;

import edu.eci.cvds.SearchLibrary.Model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends MongoRepository<Search, String>{
    List<Search> findByTitleContaining(String title);
    List<Search> findByAuthorContaining(String author);
    List<Search> findBycategoryContaining(String category);
}




