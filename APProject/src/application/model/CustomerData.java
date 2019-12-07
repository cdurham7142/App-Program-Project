package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;

/**
 * This class will represent a CustomerData object, which we is defined as having:
 * An ID, represented as a String, Customers, stored as an array of customer objects, 
 * a toString() method, and an addCustomer(..) method. 
 * This class has a constructor, getters and setters to accommodate its variables.
 *
 * @authors: Jacob De Los Santos bfn715
 * 	     Colin Durham sif159
 * UTSA CS 3443 - Group Project
 * Fall 2019
 */
public class CustomerData
{
	public ArrayList<Customers> matchedArrayList;
	public static ArrayList<Customers> customerArrayList;
	public static int j;
	private static CustomerData instance = null;
	public static String ID;
	public static String patternSelection;
	public CustomerData()
	{
		
	customerArrayList = new ArrayList<Customers>();
	}
	public static CustomerData getInstance() {
        if(instance == null)
            instance = new CustomerData();
        return instance;
    }
	public void addCustomer(Customers customer)
	{
	customerArrayList.add(customer);
	}

	public String toString()
	{
		return"";
	}
	
	public static Customers getCustomerFromID(String ID) {
		for(Customers currentCustomer: customerArrayList) {
			if (currentCustomer.getUserID().equals(ID))
				return currentCustomer;
		}
		return null;
	}
	
	public void loadCustomersFile(String fileName)
	{
		File file = new File(fileName);
		try
		{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				String firstName = values[0].toString();
				String lastName = values[1].toString();
				String phoneNumber  = values[3].toString();
				String userID = values[2].toString();
				String userPassword = values[4].toString();
				String shippingAddress = values[5].toString();
				String userCity = values[6].toString();
				String userState = values[7].toString();
				Customers customer = new Customers(firstName, lastName, phoneNumber, userID, userPassword, shippingAddress, userCity, userState);
				addCustomer(customer);
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void loadOrdersFile(String fileName)
	{
		File file = new File(fileName);
		try
		{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				String userID = values[0].toString();
				String currentLocation  = values[1].toString();
				String time = values[2].toString();
				String quantity = values[3].toString();
				String fabricType = values[4].toString();
				String fabricColor = values[5].toString();
				String orderID = values[6].toString();
				String scrunchSize = values[7].toString();
				Order order = new Order(currentLocation, time, quantity, fabricColor, fabricType,  orderID, scrunchSize);
				int zoneIdx=0;
				for(int i=0; i<customerArrayList.size();i++)
				{	
					if(customerArrayList.get(i).getUserID().equalsIgnoreCase(userID))
					{
						zoneIdx = i;
						break;
					}
				}
				customerArrayList.get(zoneIdx).addOrder(order);
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void writeOrdersFile(String filename) {
		File file = new File(filename);
		try {
			FileWriter writer = new FileWriter(file);
			for (Customers customer : customerArrayList)
				for (Order order : customer.getOrderArrayList())
					writer.write(customer.getUserID()+","+order.toString() + "\n");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeSingleOrderToFile(String filename, Order order, String userID) {
		File file = new File(filename);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(userID+ ","+ order.toString() + "\n");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeSingleCustomerToFile(String filename, Customers customer) {
		File file = new File(filename);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(customer.toString() + "\n");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeCustomersFile(String filename) {
		File file = new File(filename);
		try {
			FileWriter writer = new FileWriter(file);
			for (Customers customer : customerArrayList)
				writer.write(customer.toString() + "\n");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Customers> getCustomerArrayList() {
		return customerArrayList;
	}
	public void setCustomerArrayList(ArrayList<Customers> customerArrayList) {
		this.customerArrayList = customerArrayList;
	}
}
