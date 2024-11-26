package edu.eci.cvds.SearchLibrary.Controller;

import edu.eci.cvds.SearchLibrary.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DatabaseController {

    private final DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/table")
    public List<String> getTables() {
        return databaseService.getAllTables();
    }

    @GetMapping("/table/{tableName}")
    public List<Map<String, Object>> getTableData(@PathVariable String tableName) {
        return databaseService.getTableData(tableName);
    }
}