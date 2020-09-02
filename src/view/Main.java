package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import application.FlowerShopController;
import domain.Flower_Shop;

public class Main {
	
	private static FlowerShopController controllerShop = new FlowerShopController();

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        boolean exit = false;
	        int opcion; 
	        
         	try {
				controllerShop.createFlowerShop("La FLoristeria 01", "Calle Flor 1", "123456787", "Barcelona");
				controllerShop.createFlowerShop("La FLoristeria 02", "Calle Flor 2", "123456788", "Madrid");
				controllerShop.createFlowerShop("La FLoristeria 03", "Calle Flor 3", "123456789", "Valencia");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
	     
	        while (!exit) {
	        
	        	Menu.welcome();;	 	   	
	        
	            try {
	 
	                System.out.println("Select one Option");
	                opcion = sc.nextInt();
	 
	                switch (opcion) {
	                
	                    case 1:
	                    	//CREATE NEW SHOP
	                    	
	                    	controllerShop.menuCreateFlowerShop();	                    
	                        break;
	                    
	                    case 2:
	                    	//MOSTRAR TIENDAS
	                    	controllerShop.menuViewShops();
	                    break;
	                    
	                    case 3:
	                    	//DELETE SHOP
	                    	controllerShop.menuDeleteShop();	                    	
	                    break;	                    
	                    
	                    case 4:
	                    	System.out.println("I want to Exit the program. Bye, bye");	            	        
	                    	exit = true;
	                    break;
	                   
	                    default:
	                        System.out.println("You must enter a number between (1,2,3,4) \n");
	                }
	                
	            } catch (Exception e) {
	            	
	                System.out.println("You must enter a number \n");
	                sc.next();
	                
	            }finally{
					//System.out.println("Continue");						
				}
					
	        }
		}
}
