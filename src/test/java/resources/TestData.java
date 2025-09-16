package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePayload;
import pojo.Location;

public class TestData {
	
	public AddPlacePayload addPlacePayLoad(String language, String address)
	{
		AddPlacePayload ap=new AddPlacePayload();
		
		Location loc=new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		ap.setLocation(loc);
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setPhone_number("(+91) 983 893 3937");
		
		List<String> typesList=new ArrayList<>();
		typesList.add("shoe park");
		typesList.add("shop");
		
		ap.setTypes(typesList);
		ap.setWebsite("http://rahulshettyacademy.com");
		ap.setLanguage(language);
		
		return ap;
	}

}
