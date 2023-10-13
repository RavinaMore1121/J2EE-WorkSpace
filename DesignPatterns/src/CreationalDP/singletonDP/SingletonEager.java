package CreationalDP.singletonDP;

public class SingletonEager {
	private static SingletonEager singletonEager=new SingletonEager();
	private SingletonEager() {
		
	}
	public static SingletonEager getObject() {
		return singletonEager;
	}
}
