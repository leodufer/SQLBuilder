package py.edu.facitec.sqlbuilder;

public class SQLBuilderTest {

	public static void main(String[] args) {
		String sql = new SQLBuilder()
							.select("name", "age")
							.from("USERS")
							.where()
							.equals("id","20")
							.and()
							.equals("edad","20")
							.build();
		
		System.out.println(sql);
		
		
		String sql2 = new SQLBuilder().select().from("CLIENT").build();
		System.out.println(sql2);
		
	}

}
