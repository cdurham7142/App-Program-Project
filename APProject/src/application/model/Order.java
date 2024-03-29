package application.model;

/**
 * This class will represent an Order object, which we is defined as having:
 * An order's ID, represented as a String, the quantity of the order, represented as a String,  
 * a string demonstrating the fabric color and, a string to represent the fabric type. Lastly,
 * it has the time, size and location of the order represented as Strings.
 * This class also has a constructor, getters and setters 
 * to accommodate its variables.
 *
 * @authors: Jacob De Los Santos bfn715
 * 		     Colin Durham sif159
 * UTSA CS 3443 - Group Project
 * Fall 2019
 */
public class Order 
{
	private String currentLocation;
	private String time;
	private String quantity;
	private String fabricColor;
	private String fabricType;
	private String orderID;
	private String scrunchSize;
	public Order(String currentLocation, String time, String quantity, String fabricColor,  String fabricType, String orderID, String scrunchSize)
	{
		this.scrunchSize = scrunchSize;
		this.currentLocation = currentLocation;
		this.time = time;
		this.quantity = quantity;
		this.fabricColor =  fabricColor;
		this.fabricType  =	fabricType;
		this.orderID = orderID;
	}
	@Override
	public String toString()
	{
		return currentLocation+","+time+","+quantity+","+fabricColor+","+fabricType+","+orderID+","+scrunchSize;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getFabricColor() {
		return fabricColor;
	}
	public void setFabricColor(String fabricColor){
		this.fabricColor = fabricColor;
	}
	public String getFabricType() {
		return fabricType;
	}
	public void setFabricType(String fabricType){
		this.fabricType = fabricType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity){
		this.quantity = quantity;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getScrunchSize() {
		return scrunchSize;
	}
	public void setScrunchSize(String scrunchSize) {
		this.scrunchSize = scrunchSize;
	}
}
