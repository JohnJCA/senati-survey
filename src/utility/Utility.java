package utility;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import beans.Section;
import beans.SurveyResponse;
import sun.rmi.runtime.Log;

public class Utility {
	
	
	public static String getStringParameter(String parameter,HttpServletRequest request) {
		return (String)request.getParameter(parameter);
		
	}
	
	public static List<Section> jsonStringToArray(String jsonString) throws JsonParseException {

	    Gson gson = new Gson();
	    Type type = new TypeToken<List<Section>>(){}.getType();
	    List<Section> sectionList = gson.fromJson(jsonString, type);
		return sectionList;
	}
	
	public static JsonArray getJsonOfSurveyResponses(List<SurveyResponse> array) throws JsonParseException {
		
		Gson gson = new Gson();
		String element = gson.toJson(array,new TypeToken<List<SurveyResponse>>() {}.getType());
		JsonArray list = new JsonArray();
		list.add(element);
		return list;
		
	}
	

}
