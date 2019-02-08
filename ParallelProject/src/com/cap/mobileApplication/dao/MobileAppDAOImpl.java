package com.cap.mobileApplication.dao;

import java.util.*;

import com.cap.mobileApplication.bean.Customer;
import com.cap.mobileApplication.bean.Mobile;

public class MobileAppDAOImpl implements IMobileAppDAO
{
	static List<Mobile> mobileInventory=new ArrayList<Mobile>();
	static List<Customer> purchaseLog=new ArrayList<Customer>();
	public MobileAppDAOImpl()
	{
		mobileInventory.add(new Mobile("1001","Nokia Lumia 520",8000,20));
		mobileInventory.add(new Mobile("1002","Samsung Galaxy IV",38000,30));
		mobileInventory.add(new Mobile("1003","’Sony xperia C",15000,200));
		mobileInventory.add(new Mobile("1004","Nokia 1200 520",1000,20));
	}

	@Override
	public List<Mobile> viewInventory()
	{
		return MobileAppDAOImpl.mobileInventory;
	}

	@Override
	public List<Customer> viewPurchaseLog()
	{		
		return MobileAppDAOImpl.purchaseLog;
	}

	@Override
	public boolean deleteUsingMobileId(String id)
	{
		
		Iterator<Mobile> it = mobileInventory.iterator();
		while (it.hasNext())
		{
			Mobile value = it.next();
			if (value.getMobileid().equals(id))
			{
				mobileInventory.remove(value);				
			}
		}
		
		
				
		for(Mobile mob:mobileInventory)
		{
			System.out.println(mob.getMobileid()+", "+mob.getMobileName()+", "+mob.getMobilePrice()+", "+mob.getMobileQuantity());
		}
		
		
		return true;
		
	}
	
	@Override
	public List<Mobile> searchMobile(int startingPrice, int endPrice)
	{
		List<Mobile> temp=new ArrayList<Mobile>();
		for(Mobile mob:mobileInventory)
		{
			if(mob.getMobilePrice()>=startingPrice&&mob.getMobilePrice()<=endPrice)
			{
				temp.add(mob);
			}
		}
		return temp;
	}

	

	@Override
	public boolean addPurchaseDetails(String mobileid, String customerName, String customerEmail, String customerPhone)
	{
		Customer cus=new Customer(mobileid,customerName,customerEmail,customerPhone);
		System.out.println(customerName);
		cus.setMobileid(mobileid);
		System.out.println(purchaseLog.add(cus));
		System.out.println("Log Added!");
		for(Customer cusd:MobileAppDAOImpl.purchaseLog)
		{
			System.out.println("Purchase Log:"+cusd.getPurchaseId());
			System.out.println("Purchase Log:"+cusd.getCustomerName());
			System.out.println("Purchase Log:"+cusd.getCustomerMailId());
			System.out.println("Purchase Log:"+cusd.getCustomerPhoneNo());
		}
		
		for(Mobile mob:mobileInventory)
		{
			if(mob.getMobileid()==mobileid)
			{
				mobileInventory.set(mobileInventory.indexOf(mob), new Mobile(mob.getMobileid(),mob.getMobileName(),mob.getMobilePrice(),mob.getMobileQuantity()-1));
				return true;
			}
			
		}
		
		return true;
	}

}
