package com.ubstest.ubsTest;

import com.ubstest.berlinClock.BerlinClockGeneration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	BerlinClockGeneration clock=new BerlinClockGeneration();
    	String[] str=clock.getBerlinTime("02:08:50");
    	for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
        //System.out.println( "Hello World!" );
    }
}
