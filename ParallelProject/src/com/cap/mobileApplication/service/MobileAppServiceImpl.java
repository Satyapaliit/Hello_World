/**
 * 
 */
package com.cap.mobileApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cap.mobileApplication.bean.Customer;
import com.cap.mobileApplication.bean.Mobile;
import com.cap.mobileApplication.dao.IMobileAppDAO;
import com.cap.mobileApplication.dao.MobileAppDAOImpl;
import com.cap.mobileApplication.exception.CustomerDetailsException;
import com.capgemini.donorapplication.exception.DonorException;

public class MobileAppServiceImpl implements IMobileAppService
{
	IMobileAppDAO iMobileAppdao=new MobileAppDAOImpl();
	@Override
	public List<Mobile> viewInventory()
	{
		
		return (iMobileAppdao.viewInventory());
	}

	@Override
	public List<Customer> viewPurchaseLog()
	{
		return iMobileAppdao.viewPurchaseLog();
	}

	@Override
	public boolean deleteUsingMobileId(String id)
	{
		System.out.println("In Service Id:"+id);
		return iMobileAppdao.deleteUsingMobileId(id);
	}

	@Override
	public List<Mobile> searchMobile(int startingPrice, int endPrice)
	{
		return iMobileAppdao.searchMobile(startingPrice, endPrice);
	}

	@Override
	public boolean addPurchaseDetails(String mobileid,String customerName,String customerEmail,String customerPhone)
	{
		return iMobileAppdao.addPurchaseDetails(mobileid,customerName,customerEmail,customerPhone);
	}
	
	
	//Customer details validation

	public void validateCustomerDetails(String mobileid,String customerName,String customerEmail,String customerPhone)
	{
		List<String> validationErrors = new ArrayList<String>();

		//Validating Customer Name
		if(!(isValidName(customerName))) {
			validationErrors.add("\n Customer Name Should Be In Alphabets and minimum 3 characters long ! \n");
		}
		
		//Validating Phone Number
		if(!(isValidPhoneNumber(customerPhone))){
			validationErrors.add("\n Phone Number Should be in 10 digit \n");
		}
		//Validating Donation Amount
		if(!(isValidMobileId(mobileid))){
			validationErrors.add("\nMobile with this Id is not available \n" );
		}
		
		//validate Email
		if(!(isValidEmail(customerEmail)))
		{
			validationErrors.add("\nInvalid Email\n");
		}
		
		if(!validationErrors.isEmpty())
			throw new CustomerDetailsException(validationErrors +"");
		
	}
	
	public boolean isValidName(String customerName){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(customerName);
		return nameMatcher.matches();
	}
		
	public boolean isValidPhoneNumber(String phoneNumber){
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
		
	}
	public boolean isValidMobileId(String mobileid)
	{
		for(Mobile mob:iMobileAppdao.viewInventory())
		{
			if(mob.getMobileid().equals(mobileid))
			{
				return true;
			}
		}
		
		return false;
	}
		
			
	public boolean isValidEmail(String email)
	{
		
		Pattern idPattern = Pattern.compile("[a-zA-Z]{3,}$[@][a-z]{4,}[.][a-z]{2,}$");
		Matcher idMatcher = idPattern.matcher(email);
		
		if(idMatcher.matches())
			return true;
		else
			return false;	
	
	}
	
}

