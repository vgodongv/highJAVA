package collectionTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();
		
		for(int i=1; i<5; i++){
			System.out.println(i+"번째 사람 별명:");
			String name = sc.next();
			list.add(name);
			
		}
		
		int max = 0;
		
		for(int i=0; i<list.size(); i++){
			for(int j=i+1; j<list.size(); j++){
				if(list.get(i).length()<list.get(j).length()){
					max = list.get(j).length();
				}
			}
			
			}
		System.out.println(list.get(max));
		

	}
	
	
	
}
