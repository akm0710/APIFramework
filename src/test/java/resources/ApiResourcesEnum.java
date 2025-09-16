package resources;

public enum ApiResourcesEnum {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json");

	
	private String resource;
	
	public String getResource()
	{
		return resource;
	}
	
	ApiResourcesEnum(String resource)
	{
		this.resource=resource;
	}

}
