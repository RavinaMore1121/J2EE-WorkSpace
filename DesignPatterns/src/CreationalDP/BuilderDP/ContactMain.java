package CreationalDP.BuilderDP;

public class ContactMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact contact=new ContactBuilder().lastname("More").
				firstname("Ravina").landlinenumber(1234567).getContact();
		System.out.println(contact);
	}

}
