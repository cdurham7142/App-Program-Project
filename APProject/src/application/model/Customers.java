package application.model;
import java.util.ArrayList;

/**
 * This class will represent a Customer object, which we is defined as having:
 * A first and last name, represented as separate Strings, a phone number string,
 * a String for the customer's userID, and the customer's shipping address. Lastly, 
 * Orders, stored as an array of orders objects, a toString() method.
 * This class has a constructor, getters and setters to accommodate its variables.
 *
 * @authors: Jacob De Los Santos bfn715 
 * 			 Colin Durham sif159
 * UTSA CS 3443 - Group Project
 * Fall 2019
 */
public class Customers 
{
	private ArrayList<Order> orderArrayList;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userID;
	private String userPassword;
	private String shippingAddress;
	private String userCity;
	private String userState;
	public static int j;
	public Customers(String firstName, String lastName, String phoneNumber, String userID, String userPassword, String shippingAddress, String userCity, String userState)
	{
		this.userState = userState;
		this.userCity = userCity;
		this.firstName = firstName;
		this.shippingAddress = shippingAddress;
		orderArrayList = new ArrayList<Order>();
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userPassword = userPassword;
		this.userID = userID; 
		
	}
	public void addOrder(Order order)
	{                          
		orderArrayList.add(order);
	}
	@Override
	public String toString()
	{
		return firstName+","+lastName+","+userID+","+phoneNumber+","+userPassword+","+shippingAddress+","+userCity+","+userState; 
	}
	public ArrayList<Order> getOrderArrayList() {
		return orderArrayList;
	}
	public void setOrderArrayList(ArrayList<Order> orderArrayList) {
		this.orderArrayList = orderArrayList;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserSate() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
}
