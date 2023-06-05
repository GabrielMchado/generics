package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Products;
import services.CalculationService;

public class ProgramGenerics {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Products> list = new ArrayList<Products>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("/home/usuario/in.txt"))){
			
			String line = br.readLine();
			while(line != null) {
				String fields[] = line.split(",");
				list.add(new Products(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			Products x = CalculationService.max(list);
			System.out.println("MAX: ");
			System.out.println(x);
						
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
