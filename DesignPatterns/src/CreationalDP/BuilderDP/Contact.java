package CreationalDP.BuilderDP;

public class Contact {
	private String firstname;
	private String middlename;
	private String lastname;
	private String nickname;
	private String email;
	private long mobilenumber;
	private long landlinenumber;
	private String address;
	private String gender;
	private int age;
	private String DateOfBirth;
	public Contact(String firstname, String middlename, String lastname, String nickname, String email,
			long mobilenumber, long landlinenumber, String address, String gender, int age, String dateOfBirth) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.nickname = nickname;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.landlinenumber = landlinenumber;
		this.address = address;
		this.gender = gender;
		this.age = age;
		DateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Contact [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", nickname=" + nickname + ", email=" + email + ", mobilenumber=" + mobilenumber + ", landlinenumber="
				+ landlinenumber + ", address=" + address + ", gender=" + gender + ", age=" + age + ", DateOfBirth="
				+ DateOfBirth + "]";
	}

}
