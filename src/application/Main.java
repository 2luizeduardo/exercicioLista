package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registred? ");
		int newEmployees = sc.nextInt();
		
		List<Employee> list= new ArrayList<>();
		
		for(int i=1; i<=newEmployees; i++) {
			System.out.printf("\nEmployee #%d:", i);
			System.out.print("\nId: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			for(int x=0; x<list.size(); x++) {
				while(list.get(x).getId()==id) {
					System.out.print("Id already taken. Try again: ");
					id = sc.nextInt();
					sc.nextLine();
				}
			}
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
			
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		//Metodo q usa esse stream
		
		/*Employee test = list.stream().filter(x -> x.getId()==id).findFirst().orElse(null);
						
		if(test == null)
			System.out.println("This id does not exist!");
		else {
			System.out.print("Enter the percentage: ");
			test.increaseSalary(sc.nextDouble());
		}*/
		
		//Metodo que tentei fazer, dava pra fazer por função externa
		
		int pos=-1;
		
		for(int x=0; x<list.size(); x++) {
			if(list.get(x).getId()==id) {
				pos=x;
			}
		}
		
		if(pos==-1)
			System.out.println("This id does not exist!");
		else {

			System.out.print("Enter the percentage: ");
			list.get(pos).increaseSalary(sc.nextDouble());
		}
			
		
		System.out.println("\nList of employees:");
		
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
