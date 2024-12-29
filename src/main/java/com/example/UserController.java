package com.example;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {


    private static Map<Integer, String> users = new HashMap<>();

    @GET
    public Map<Integer, String> getUsers() {
        return users;
    }

    @POST
    public String createUser(String name) {
        int id = users.size() + 1;
        users.put(id, name);
        return "User " + name + " added with ID " + id;
    }

    @DELETE
    @Path("/{id}")
    public String deleteUser(@PathParam("id") int id) {
        if (users.containsKey(id)) {
            String name = users.remove(id);
            return "User " + name + " removed.";
        } else {
            throw new NotFoundException("User with ID " + id + " not found.");
        }
    }
}