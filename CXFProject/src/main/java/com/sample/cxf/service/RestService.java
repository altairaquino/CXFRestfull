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

import com.sample.cxf.dto.JsonResponse;

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

}