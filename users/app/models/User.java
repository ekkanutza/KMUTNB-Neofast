package models;
import play.*;
import siena.*;
import java.util.*;

@Entity
public class User extends Model {
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	@Column("name") @NotNull
	public String name;
	
	@Column("createdDate") @NotNull
	public Date createdDate;
	
	@Column("updatedDate") @NotNull
	public Date updatedDate;
	public static Query<User> all() {
		 return Model.all(User.class);
	}
	public static List<User> findAll() {
		 return all().order("createdDate").fetch();
	}
	
	public static User findById(Long id) {
		 return all().filter("id", id).get();
	}
}