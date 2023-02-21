package page;

import java.util.Random;

public class BasePage {
	
	
public int generateRandomNumber(int random) {
		
		Random rnd = new Random();
		int generatedNum= rnd.nextInt(random);
		return generatedNum;

}}
