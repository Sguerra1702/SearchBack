package edu.eci.cvds.SearchLibrary;

import edu.eci.cvds.SearchLibrary.Model.Search;
import edu.eci.cvds.SearchLibrary.Config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import javax.sql.DataSource;

import java.sql.Connection;

@SpringBootTest
class SearchLibraryApplicationTests {


	@Autowired
	private DataSource managementDataSource;
	/* 
	@Test
	void testDefaultConstructor() {
		Search search = new Search();
		assertNull(search.getBookID());
		assertNull(search.getTitle());
		assertNull(search.getAuthor());
		assertNull(search.getCategory());
		assertNull(search.getisbn());
	}

	@Test
	void testParameterizedConstructor() {
		Search search = new Search("Test Title", "Test Author", "Test Category");
		assertEquals("Test Title", search.getTitle());
		assertEquals("Test Author", search.getAuthor());
		assertEquals("Test Category", search.getCategory());
		assertNull(search.getBookID());
		assertNull(search.getisbn());
	}

	@Test
	void testSettersAndGetters() {
		Search search = new Search();
		search.setBookId("1L");
		search.setTitle("Test Title");
		search.setAuthor("Test Author");
		search.setCategory("Test Category");
		search.setisbn(123456789L);

		assertEquals(1L, search.getBookID());
		assertEquals("Test Title", search.getTitle());
		assertEquals("Test Author", search.getAuthor());
		assertEquals("Test Category", search.getCategory());
		assertEquals(123456789L, search.getisbn());
	}

	@Test
	void testSetBookId() {
		Search search = new Search();
		search.setBookId("123L");
		assertEquals(123L, search.getBookID());
	}

	@Test
	void testSetTitle() {
		Search search = new Search();
		search.setTitle("New Title");
		assertEquals("New Title", search.getTitle());
	}

	@Test
	void testSetAuthor() {
		Search search = new Search();
		search.setAuthor("New Author");
		assertEquals("New Author", search.getAuthor());
	}

	@Test
	void testSetCategory() {
		Search search = new Search();
		search.setCategory("New Category");
		assertEquals("New Category", search.getCategory());
	}

	@Test
	void testSetIsbn() {
		Search search = new Search();
		search.setisbn(987654321L);
		assertEquals(987654321L, search.getisbn());
	}
	*/
	@Test
	void testConexion() throws Exception{
		try (Connection connection = managementDataSource.getConnection()){
			assertNotNull(connection,"la base de datos fallo xd ");
		}
	}
}

