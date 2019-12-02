package application.model;
import java.util.ArrayList;
public class Customers 
{
	private ArrayList<Order> orderArrayList;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userID;
	private String userPassword;
	public static int j;
	public Customers(String firstName, String lastName, String phoneNumber, String userID, String userPassword)
	{
		this.firstName = firstName;
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
		//int i = 0;
		//String string = movieName + " [" + movieID + "], Genre:" + movieGenre + ", Cast:" + castArrayList.size() + "\n";
		//while(i<castArrayList.size())
		//{
		//	string+= castArrayList.get(i).toString()+"\n";
		//	i++;
		//}
		return ""; //string;
		// Getters and Setters
	}
	public ArrayList<Order> getOrderArrayList() {
		return orderArrayList;
	}
	public void setCastArrayList(ArrayList<Order> orderArrayList) {
		this.orderArrayList = orderArrayList;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String movieName) {
		this.firstName = movieName;
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
	
}