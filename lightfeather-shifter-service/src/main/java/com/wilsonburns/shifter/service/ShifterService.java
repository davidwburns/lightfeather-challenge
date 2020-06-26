package com.wilsonburns.shifter.service;

import org.springframework.stereotype.Component;

public interface ShifterService {
	
	public void writeCipher(String shifted) throws Exception;
	public String shift(Integer offset, String sentence);

}
