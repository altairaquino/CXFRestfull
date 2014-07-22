package com.sample.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Service;

import com.sample.cxf.dto.JsonResponse;

@CrossOriginResourceSharing(
        allowOrigins = {"*"},
        allowAllOrigins = true
)

@Service
@Path("/" + RestService.VERSION_NAME)
public class RestService {
	
	public static final String VERSION_NAME = "v1";
	
	@GET
	@Path("/test/{name}{format:(/format/[^/]+?)?}{encoding:(/encoding/[^/]+?)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@PathParam("name") String name) {
		List<JsonResponse> list = new ArrayList<JsonResponse>();
		try {
			list.add(new JsonResponse(name));
			return Response.ok(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/test2{name:(/name/[^/]+?)?}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test2(@PathParam("name") String name) {
		List<JsonResponse> list = new ArrayList<JsonResponse>();
		try {
			if (name == null){
				list.add(new JsonResponse("vazio"));
			}else{				
				list.add(new JsonResponse(name));
			}
			return Response.ok(list).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}