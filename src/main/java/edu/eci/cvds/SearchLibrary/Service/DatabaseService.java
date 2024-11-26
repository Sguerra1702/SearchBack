package edu.eci.cvds.SearchLibrary.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Método para obtener los nombres de las tablas de la base de datos
    public List<String> getAllTables() {
        String sql = "SHOW TABLES"; // Consulta para obtener las tablas en MySQL
        return jdbcTemplate.queryForList(sql, String.class); // Ejecuta la consulta y obtiene los resultados
    }

    public List<Map<String, Object>> getTableData(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.queryForList(sql);
    }
}
