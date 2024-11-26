package edu.eci.cvds.SearchLibrary.Repository;

import edu.eci.cvds.SearchLibrary.Model.Search;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long>{
    List<Search> findByTitleContaining(String title);
    List<Search> findByAuthorContaining(String author);
    List<Search> findBycategoryContaining(String category);
}




