/**
 * 
 */
package com.cap.mobileApplication.pi;

import java.util.Scanner;

import com.cap.mobileApplication.bean.Mobile;
import com.cap.mobileApplication.service.IMobileAppService;
import com.cap.mobileApplication.service.MobileAppServiceImpl;

public class MobileAppMain
{
	public static void showMenu()
	{
		System.out.println("\n______________________________\n");			
		System.out.println("--------Mobile Shop---------");
		System.out.println("______________________________");
		System.out.println();
		System.out.println();
		System.out.println("Select Service...");
		System.out.println("1:View available mobiles.");
		System.out.println("2:Buy Mobile");
		System.out.println("3:Search mobile using price range.");
		System.out.println("4:Remove Mobile from shop.\n5:Exit");
	}
	public static void main(String[] args)
	{	
		IMobileAppService iMobileAppService =new MobileAppServiceImpl();	
		
		int option=0;
				
		Scanner scanner=new Scanner(System.in);
				//Show Menu	
			showMenu();
			
			System.out.println("Your Option?:");
			
				option=scanner.nextInt();
							
			switch(option)
			{
			case 1:
			{		
				System.out.println("------Available Mobile Phones are------");
				for(Mobile mob:iMobileAppService.viewInventory())
				{
					System.out.println(mob.getMobileid()+", "+mob.getMobileName()+", "+mob.getMobilePrice()+", "+mob.getMobileQuantity());
				}
			}
			break;
			case 2:
			{
				System.out.print("Mobile ID?:");
				scanner.next();
				String mobId=scanner.nextLine();	
				
				System.out.print("Customer Name?:");
				String customerName=scanner.nextLine();
				
				System.out.print("Customer Email?:");
				String customerMailId=scanner.nextLine();
				
				System.out.print("Customer Phone No.?:");
				String customerPhoneNo=scanner.nextLine();
								
				iMobileAppService.addPurchaseDetails(mobId,customerName,customerMailId,customerPhoneNo);
				System.out.println("Thanks for Shopping with us.");
				
			}
			break;
			case 3:
			{
				scanner.nextLine();
				System.out.print("Starting price?:");
				int fromPrice;
				fromPrice=scanner.nextInt();
				System.out.print("Ending price?:");
				scanner.nextLine();
				int toPrice;
				toPrice=scanner.nextInt();	
				System.out.println("Reaching!");
				System.out.println("Call:"+iMobileAppService.searchMobile(fromPrice, toPrice));
				for(Mobile mob:iMobileAppService.searchMobile(fromPrice, toPrice))
				{
					System.out.println(mob.getMobileid()+", "+mob.getMobileName()+", "+mob.getMobilePrice()+", "+mob.getMobileQuantity());
				}
								
			}
			break;
			case 4:
			{
				System.out.println("Delete Mobile with ID:");
				scanner.nextLine();
				String id=scanner.nextLine();				
				iMobileAppService.deleteUsingMobileId(id);
			}
			break;
			case 5:
			{
				System.exit(0);
			}
			break;
			}
			
			scanner.close();	
	
		
	}

}
