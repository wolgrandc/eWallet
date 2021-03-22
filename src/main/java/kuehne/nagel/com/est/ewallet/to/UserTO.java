package kuehne.nagel.com.est.ewallet.to;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import kuehne.nagel.com.est.ewallet.model.User;

public class UserTO {

	private String name;
	private LocalDate birthday;
	private String phone;
	private String personalIdCode;
	private String email;
	private String login;

	public UserTO() {
		super();
	}

	public UserTO(User user) {
		super();
		this.name = user.getName();
		this.birthday = user.getBirthday();
		this.phone = user.getPhone();
		this.personalIdCode = user.getPersonalIdCode();
		this.email = user.getEmail();
		this.login = user.getLogin();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonalIdCode() {
		return personalIdCode;
	}

	public void setPersonalIdCode(String personalIdCode) {
		this.personalIdCode = personalIdCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public static List<UserTO> toUserTO(List<User> userList) {
		List<UserTO> users = userList.stream().map(user -> (new UserTO(user))).collect(Collectors.toList());
		return users;
	}
	
	

}
