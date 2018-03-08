package edu.unh.cs980.methods;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import edu.unh.cs980.utils.ProjectUtils;

public class EntityLinking {
	private static Gson gson = ProjectUtils.getGsonStringBuilder();

	public static ArrayList<EntityWord> getEntityList(String jsonStr) {
		JsonParser jsonParser = new JsonParser();
		JsonObject gsonObject = (JsonObject) jsonParser.parse(jsonStr);

		Type listType = new TypeToken<List<EntityWord>>() {
		}.getType();
		ArrayList<EntityWord> annotatedList = gson.fromJson(gsonObject.get("Resources"), listType);

		return annotatedList;

	}
}
