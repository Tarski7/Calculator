package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

public static void main(String[] args) {
		
    	File file = new File("calculator.txt");
    	ArrayList<String> list = new ArrayList<>();
    	
    	try {
    	Scanner scan = new Scanner(file);
    	
    	while (scan.hasNextLine()) {
    		
    		String text = scan.nextLine();
    		StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
    		
    		while (stringTokenizer.hasMoreTokens()) {
    			String token = stringTokenizer.nextToken();
    			list.add(token);
    		}
    	}
    	scan.close();
    	
    	int output = Integer.parseInt(list.get(list.size()-1));
    	char sign = ' ';
    	
    	for (int i = 0; i < list.size()-2; i++) {
    		
    		if (list.get(i).matches("[a-z]+")) {
    			
    			switch (list.get(i)) {
				case "add":
					sign = '+';
					break;
				case "subtract":
					sign = '-';
					break;
				case "multiply":
					sign = '*';
					break;
				case "divide":
					sign = '/';
					break;
				default:
					break;
				}
    			
    		} else if (list.get(i).matches("\\d+")) {
    			
    			switch (sign) {
    			case '+':
    				output += Integer.parseInt(list.get(i));
    				break;
    			case '-':
    				output -= Integer.parseInt(list.get(i));
    				break;
    			case '*':
    				output *= Integer.parseInt(list.get(i));
    				break;
    			case '/':
    				output /= Integer.parseInt(list.get(i));
    				break;
    			}
    		}
    	}
    	
    	System.out.println(output);
    	
    	} catch (FileNotFoundException e) {
    		System.out.println("Cannot find a file!");
    	}
    }
}
