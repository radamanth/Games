package com.radamanth.d20modern.computer.generator;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.radamanth.d20modern.computer.Computer;

public abstract class ComputerGenerator {

	public static Computer generateComputer(File xmlInput, int depth,
			int cryptedDC, int securityDC) {
		Computer c = new Computer();
		try {
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(xmlInput));
			XMLDecoder decoder = new XMLDecoder(bin);
			Object o = decoder.readObject();
			if (o instanceof Computer) {
				c =(Computer)o;
				System.out.println( c.getName() + " Loaded.");
				
			}
			 
			decoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}

	public final static void main(String[]args) {
		File f = new File("Skynet.xml");
		ComputerGenerator.generateComputer(f, 12, 20, 20);
	}
	
	
	

}
