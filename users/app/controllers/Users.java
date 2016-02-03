package controllers;
import java.util.*;
import models.User;
import play.mvc.*;
public class Users extends Controller {
///part1
	public static void index() {
		list();
	}
	public static void list() {
		List<User> users = User.findAll();
		render(users);
	}
////part2	
	public static void add(String name) {
		 if(name == null || name.isEmpty()){
			 render();
		 }
		 else {
			 User user = new User();
			 user.name = name;
			 user.createdDate = new Date();
			 user.updatedDate = new Date();
			 user.insert();
			 list();
		 }
	}	
/////part3
	public static void edit(Long id, String name) {
		notFoundIfNull(id);
		User user = User.findById(id);
		if(name == null || name.isEmpty()) {
			if(user == null){
					list();
			} else {
				render(user);
			}
		} else {
			user.name = name;
			user.updatedDate = new Date();
			user.update();
			list();
		 	}
		}
///part4
	public static void delete(Long id,Boolean status) {
		 notFoundIfNull(id);
		 User user = User.findById(id);
		 if(status == null || status == false) {
		 if(user == null){
			 list();
		 } else {
			 render(user);
		 }
		 } else {
			 user.delete();
			 list();
		 }
	}
/////part5 create by me
	public static void university() {
		List<User> users = User.findAll();
		render(users);
	}
}
