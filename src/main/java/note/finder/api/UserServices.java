package note.finder.api;

import note.finder.entity.User;
import note.finder.persistence.GenericDao;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserServices {

    GenericDao dao;

    /**
     * retrieves all users and their foreign key references
     * @return json array of user objects and references
     */
    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {

        dao = new GenericDao<>(User.class);
        List<User> users = dao.getAllWithFK(User.class, "foreignKey");
        return Response.status(200).entity(users).build();
    }


    /**
     * updates a user
     * @param id id parameter of user to be updated
     * @param updatedUser user object to be updated and merged
     * @return json response 200 - confirmation
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateScale(@PathParam("id") int id, User updatedUser) {
        dao = new GenericDao<>(User.class);
        updatedUser.setId(id);
        dao.update(updatedUser, id); // Pass ID to retrieve existing entity
        return Response.status(200).entity("{\"message\": \"Category updated successfully\"}").build();
    }

    /**
     * creates a new user
     * @param user user object to be inserted
     * @return json response 201 - confirmation
     */
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createScale(User user) {
        dao = new GenericDao<>(User.class);
        dao.insert(user);
        return Response.status(201).entity("{\"message\": \"User created successfully\"}").build();
    }


    /**
     * deletes a user
     * @param id id of user to be deleted
     * @return json 200 response - confirmation
     */
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteCategory(@PathParam("id") int id) {
        dao = new GenericDao<>(User.class);
        dao.delete(User.class, id);
        return Response.status(200).entity("{\"message\": \"User deleted successfully\"}").build();
    }
}