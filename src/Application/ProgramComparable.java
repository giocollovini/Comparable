package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entities.Employee;

public class ProgramComparable {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt"; 
		
		System.out.println("Programa para ler um arquivo .csv contendo os dados nome e valor, separados por vírgula.");
		System.out.println("Ordenar esse arquivo por nome de forma crescente.");
		System.out.println();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String employeeCsv = br.readLine(); 
			while (employeeCsv != null) { 
				String[] fields = employeeCsv.split(","); 
				list.add(new Employee(fields[0], Double.parseDouble(fields[1]))); 
				employeeCsv = br.readLine(); 
			} 
			Collections.sort(list); 
			for (Employee emp : list) { 
				System.out.println(emp.getName() + ", " + emp.getSalary()); 
			}
		
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	} 
}