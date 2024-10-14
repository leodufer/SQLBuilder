package py.edu.facitec.sqlbuilder;

public class SQLBuilder {
	
	private StringBuilder query;

	public SQLBuilder() {
		this.query = new StringBuilder();
	}
	
	public SQLBuilder select(String... columns ) {
		if(columns.length == 0) {
			this.query.append("SELECT * ");
		}else {
			query.append("SELECT ").append(String.join(", ", columns)).append(" ");
		}
		
		return this;
	}
	
	public SQLBuilder from(String table) {
		if(table ==null || table.isEmpty())
			throw new IllegalArgumentException("table name not must null or empty");
		this.query.append("FROM ").append(table).append(" ");
		return this;
	}
	
	public SQLBuilder where(String condition) {
		this.query.append("WHERE ").append(condition).append(" ");
		return this;
	}
	public SQLBuilder where() {
		this.query.append("WHERE ");
		return this;
	}
	
	public SQLBuilder equals(String field, String value) {
		this.query.append(field).append(" = ").append(value).append(" ");
		return this;
	}
	
	public SQLBuilder distint(String field, String value) {
		//TODO distint operator
		return this;
	}
	
	public SQLBuilder and() {
		this.query.append(" AND ");
		return this;
	}
	
	public SQLBuilder or() {
		this.query.append(" OR ");
		return this;
	}
	
	
	public String build() {
		return this.query.append(";").toString().trim();
	}
	

	
}
