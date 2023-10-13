package com.jspiders.multithreading.main;
import com.jspiders.multithreading.resource.Pizza;
import com.jspiders.multithreading.thread.Dominos;
import com.jspiders.multithreading.thread.Friends;
public class PizzaMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza=new Pizza();
		Friends friends=new Friends(pizza);
		Dominos dominos=new Dominos(pizza);
		friends.start();
		dominos.start();
	}
}