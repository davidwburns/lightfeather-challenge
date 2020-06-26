package com.wilsonburns.shifter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.wilsonburns.shifter.model.Message;
import com.wilsonburns.shifter.service.ShifterService;

@RestController
public class ShiftCipherController {
	
	@Autowired
	ShifterService shifterService;
	
	static final String ENCODED_MESSAGE = "EncodedMessage";

	@PostMapping(path = "/api/encode", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> encode(@RequestBody Message message) throws IOException {
		String shifted = null;
		
		JsonObject returnJson = new JsonObject();	
		
		if(message.getShift() == null || message.getMessage() == null || message.getMessage().equals("")) {
			returnJson.addProperty(ENCODED_MESSAGE, "");
			return new ResponseEntity<>(returnJson.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
				
		try {
			shifted = shifterService.shift(message.getShift(), message.getMessage());
			shifterService.writeCipher(shifted);
		} catch (Exception e) {
			returnJson.addProperty(ENCODED_MESSAGE, "");
			return new ResponseEntity<>(returnJson.toString(),HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		returnJson.addProperty(ENCODED_MESSAGE, shifted);
		
		return new ResponseEntity<>(returnJson.toString(), HttpStatus.OK);
	}

}
