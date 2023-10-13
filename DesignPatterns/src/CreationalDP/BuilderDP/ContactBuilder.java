package CreationalDP.BuilderDP;
public class ContactBuilder {
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
	public ContactBuilder firstname(String firstname) {
		this.firstname=firstname;
		return this;
	}
	public ContactBuilder middlename(String middlename) {
		this.middlename=middlename;
		return this;
	}	
	public ContactBuilder lastname(String lastname) {
		this.lastname=lastname;
		return this;
	}	
	public ContactBuilder nickname(String nickname) {
		this.nickname=nickname;
		return this;
	}	
	public ContactBuilder email(String email) {
		this.email=email;
		return this;
	}	
	public ContactBuilder mobilenumber(long mobilenumber) {
		this.mobilenumber=mobilenumber;
		return this;
	}	
	public ContactBuilder landlinenumber(long landlinenumber) {
		this.landlinenumber=landlinenumber;
		return this;
	}	
	public ContactBuilder address(String address) {
		this.address=address;
		return this;
	}	
	public ContactBuilder gender(String gender) {
		this.gender=gender;
		return this;
	}	
	public ContactBuilder age(int age) {
		this.age=age;
		return this;
	}	
	public ContactBuilder DateOfBirth(String DateOfBirth) {
		this.DateOfBirth=DateOfBirth;
		return this;
	}
	public Contact getContact() {
		Contact contact=new Contact(firstname,middlename,lastname,
				nickname,email,mobilenumber,landlinenumber,address,
				gender,age,DateOfBirth);
		return contact;
	}
}
