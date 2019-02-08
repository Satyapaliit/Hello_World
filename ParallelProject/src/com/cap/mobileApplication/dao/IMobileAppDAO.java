/**
 * 
 */
package com.cap.mobileApplication.dao;

import java.util.*;

import com.cap.mobileApplication.bean.Customer;
import com.cap.mobileApplication.bean.Mobile;

/**
 * @author SATYAPKU
 *
 */
public interface IMobileAppDAO
{
	List<Mobile> viewInventory();
	List<Customer> viewPurchaseLog();
	boolean deleteUsingMobileId(String id);
	List<Mobile> searchMobile(int startingPrice,int endPrice);
	boolean addPurchaseDetails(String mobileid,String customerName,String customerEmail,String customerPhone);
}
