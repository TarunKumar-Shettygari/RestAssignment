package com.accolite.au.restAssignment.RestAssignment.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.au.restAssignment.RestAssignment.model.Profile;
import com.accolite.au.restAssignment.RestAssignment.service.ProfileService;

@Path("profiles")
public class ProfileResource {
	
	ProfileService profileService=new ProfileService();
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String name) {
		return profileService.getProfile(name);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProfile(Profile profile) {
		return profileService.updateProfile(profile);
	
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProfile(@PathParam("profileName") String name) {
		return profileService.deleteProfile(name);
	
	}

}
