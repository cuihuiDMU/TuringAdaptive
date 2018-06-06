package com.calculate;

import java.math.BigDecimal;

public class TurnDecimal {
	public static float turnDecimal(float f6){
		
		BigDecimal b = new BigDecimal(f6);
		float f2 = b.setScale(4, BigDecimal.ROUND_HALF_UP).floatValue();
		return f2;
	}
	public static float calculateDecimal(float f1, float f2){
		
		float f = new BigDecimal((float)f1/f2).setScale(4, BigDecimal.ROUND_HALF_UP).floatValue(); 
			return f;
		}
}
