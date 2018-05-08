package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

	//Method returns the ArrayList of String tokens from the file
	public static ArrayList<String> getList() {
		
		File file = new File("/home/tarski/STSworkspace/Calculator/src/main/java/calculator/calculator.txt");
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
    	
    	} catch (FileNotFoundException e) {
    		System.out.println("Cannot find a file!");
    	}
    	
    	return list;
	}
	
	//Method returns the output - score of mathematical operations 
	public static int getOutput(ArrayList<String> list) {
		
		//get the last element from ArrayList. It's number after "apply" word
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
				case "modulo":
					sign = '%';
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
    			case '%':
    				output %= Integer.parseInt(list.get(i));
    				break;
    			}
    		}
    	}
    	
    	return output;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> list = getList();
		int output = getOutput(list);
		System.out.println("Output: " + output);
    }
}
