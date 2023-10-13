package CreationalDP.singletonDP;

public class SingletonLazy {
	private static SingletonLazy singletonLazy;
	private SingletonLazy() {
		System.out.println("Constructor Accessed");
	}
	public static SingletonLazy getObject() throws Exception{
		if(singletonLazy==null) {
			singletonLazy=new SingletonLazy();
		}
		return singletonLazy;
	}
}
