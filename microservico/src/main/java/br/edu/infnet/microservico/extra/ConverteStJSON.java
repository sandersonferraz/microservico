package br.edu.infnet.microservico.extra;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConverteStJSON {

	public static String converteStringParaJson(String string) {
		return new Gson().fromJson(string, JsonObject.class).toString();
	}
	
}
