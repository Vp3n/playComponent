package models;

import java.util.List;

import javax.persistence.Entity;

import net.sf.oval.constraint.NotNull;

import play.db.jpa.Model;

@Entity
public class MenuItem extends Model {
	
	@NotNull
	public String name;
	
	public boolean isAdmin;
	
	
	public static List<MenuItem> findMenuItems(boolean isAdmin) {
		return find("SELECT m " +
				"FROM MenuItem m " +
				"WHERE isAdmin = :isAdmin")
				.bind("isAdmin", isAdmin)
				.fetch();
	}
}
