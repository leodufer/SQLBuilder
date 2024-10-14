package py.edu.facitec.sqlbuilder.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import py.edu.facitec.sqlbuilder.SQLBuilder;

class SQLBuilderTest {

	private SQLBuilder sqlBuilder;
	@Test
	void generateSQLSelectWitnArguments() {
		String sql = sqlBuilder
				.select("name", "age")
				.build();
		assertEquals("SELECT name, age ;", sql);
		
	}
	@Test
	void generarSQLSelectWithoutArguments() {
		String sql = sqlBuilder
				.select()
				.build();
		assertEquals("SELECT * ;", sql);
	}
	@Test
	void generarSQLFromNull() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			sqlBuilder
					.select()
					.from(null)
					.build();
		});

	}
	
	@Test
	void generarSQLFROMEmpty() {
		assertThrows(IllegalArgumentException.class, ()->{
			sqlBuilder
					.select()
					.from("")
					.build();
		});
		
	}
	@BeforeEach
	void generarSQLBuilder() {
		sqlBuilder = new SQLBuilder();
	}
}
