package mvcdemo.model;

import dao.DB;
import dao.UserDao;

public class Authenticator {
 
	public String authenticate(String username, String password) {
		try {
			UserDao dao = new UserDao(DB.getConnection());
			if (dao.authenticate(username, password)) {
				return "success";
			}
			return "failure";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
}