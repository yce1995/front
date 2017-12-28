package cn.et.main;

import java.util.Timer;

 
public class TimerIndex {
	public static void main(String[] args) {
		Timer time = new Timer();
		time.schedule(new MyTimerIndex(), 2000, 5000);
	}
}
 