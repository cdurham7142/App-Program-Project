package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerData
{
	public ArrayList<Customers> matchedArrayList;
	public ArrayList<Customers> customerArrayList;
	public static int j;
	private static CustomerData instance = null;
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
				Customers customer = new Customers(firstName, lastName, phoneNumber, userID, userPassword);
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
				// boolean if an associated image
				Order order = new Order(currentLocation, time, quantity, fabricType, fabricColor, orderID);
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
	public ArrayList<Customers> getMovieByName(String name)
	{
		
		matchedArrayList = new ArrayList<Customers>();
		for(int i=0; i<customerArrayList.size();i++)
		{	
			if(customerArrayList.get(i).getFirstName().contains(name))
			{
				matchedArrayList.add(customerArrayList.get(i));
			}
		}
		return matchedArrayList;
	}
}