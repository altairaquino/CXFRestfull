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

import org.springframework.stereotype.Service;

import com.sample.cxf.dto.JsonResponse;

@Service
@Path("/example")
public class RestService {
	
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
			return Response.status(Status.METHOD_NOT_ALLOWED).build();
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
			return Response.status(Status.METHOD_NOT_ALLOWED).build();
		}
	}

}
