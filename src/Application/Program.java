package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;



public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products:");
		int n = sc.nextInt();
		for (int i = 1; i<=n ; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			if (ch == 'i') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} 
			else if (ch == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				list.add(new Product(name, price));
			}
			else {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacturer date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
		}
		
		System.out.println("PRICE TAGS:");
		for (Product prt : list) {
			System.out.println(prt.priceTag());
			
		}
		
		
		
		
		
		
		
		
		sc.close();
	}

}
