package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file fullpath:");
		
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> votes = new TreeMap<>();
			
			String line = br.readLine();
			
			while(line !=null){
			String[] fields = line.split(",");
			String username = fields[0];
			
			int vote = Integer.parseInt(fields[1]);
		
			if (votes.containsKey(username)) { 
				votes.put(username, votes.get(username) + vote); 
			} else { votes.put(username, vote); }
			
			line = br.readLine(); 
		
			}
			
			 System.out.println("Vote results:"); 
			 for (String key : votes.keySet()) { 
				 System.out.println(key + ": " + votes.get(key)); }
			
			}catch (IOException e) {
				System.out.println("Error:" + e.getMessage());
			}
		
			sc.close();
			
		
	}

}
