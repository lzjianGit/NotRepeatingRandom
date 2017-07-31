package util;

import java.util.Random;

public class RandomNum {
	public Integer randomNum(){
		Integer i = 0;
		int max = 200000000;
		int min = 100000000;
		Random random = new Random();
		i = random.nextInt(max) % (max - min + 1) + min;
		return i;
	}
}
