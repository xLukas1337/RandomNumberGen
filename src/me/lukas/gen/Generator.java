package me.lukas.gen;

import java.util.Random;

public class Generator {

	public static int generateInt(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static float generateFloat(Float min, Float max) {
//		return ThreadLocalRandom.current().nextFloat(min, max + 1);
		return 30;
	}

}
