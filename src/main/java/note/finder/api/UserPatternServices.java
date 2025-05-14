package note.finder.api;

import note.finder.entity.UserPattern;
import note.finder.persistence.GenericDao;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patterns")
public class UserPatternServices {

    GenericDao dao;

    /**
     * retrieves all patterns and their foreign key references
     * @return json array of pattern objects and references
     */
    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {

        dao = new GenericDao<>(UserPattern.class);
        List<UserPattern> patterns = dao.getAllWithFK(UserPattern.class, "foreignKey");
        return Response.status(200).entity(patterns).build();
    }


    /**
     * updates a pattern
     * @param id id parameter of pattern to be updated
     * @param updatedPattern pattern object to be updated and merged
     * @return json response 200 - confirmation
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateScale(@PathParam("id") int id, UserPattern updatedPattern) {
        dao = new GenericDao<>(UserPattern.class);
        updatedPattern.setId(id);
        dao.update(updatedPattern, id); // Pass ID to retrieve existing entity
        return Response.status(200).entity("{\"message\": \"Category updated successfully\"}").build();
    }

    /**
     * creates a new pattern
     * @param pattern pattern object to be inserted
     * @return json response 201 - confirmation
     */
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createScale(UserPattern pattern) {
        dao = new GenericDao<>(UserPattern.class);
        dao.insert(pattern);
        return Response.status(201).entity("{\"message\": \"Pattern created successfully\"}").build();
    }


    /**
     * deletes a pattern
     * @param id id of pattern to be deleted
     * @return json 200 response - confirmation
     */
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteCategory(@PathParam("id") int id) {
        dao = new GenericDao<>(UserPattern.class);
        dao.delete(UserPattern.class, id);
        return Response.status(200).entity("{\"message\": \"Pattern deleted successfully\"}").build();
    }
}