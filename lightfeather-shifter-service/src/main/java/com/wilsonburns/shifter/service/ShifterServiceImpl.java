package com.wilsonburns.shifter.service;

import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class ShifterServiceImpl implements ShifterService{

	@Override
	public void writeCipher(String shifted) throws Exception {
		PrintWriter writer;
		writer = new PrintWriter("ciphered-message.txt", "UTF-8");
		writer.println(shifted);
		writer.close();	
	}

	@Override
	public String shift(Integer shift, String message) {
		String s = "";
		for (int i = 0; i < message.length(); i++) {
			char c = (char) (message.charAt(i));
			if (c >= 'A' && c <= 'Z') {
				s += (char) ((c - 'A' + shift) % 26 + 'A');
			} else if (c >= 'a' && c <= 'z') {
				s += (char) ((c - 'a' + shift) % 26 + 'a');
			} else {
				s += c;
			}
		}
		return s;
	}

}
