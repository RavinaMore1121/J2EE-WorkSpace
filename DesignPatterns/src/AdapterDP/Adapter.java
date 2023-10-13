package AdapterDP;

public class Adapter extends Employee implements Event{
	@Override
	public void womensDay(Adapter adapter)
	{
		adapter.setId(1);
		adapter.setName("Veera");
		adapter.setEmail("veera@gmail.com");
		System.out.println("Chief guest for the womens day is"+adapter.getName());
	}
	public void mensDay(Adapter adapter)
	{
		adapter.setId(1);
		adapter.setName("Saura");
		adapter.setEmail("saura@gmail.com");
		System.out.println("Chief guest for the mens day is"+adapter.getName());
	}
}
