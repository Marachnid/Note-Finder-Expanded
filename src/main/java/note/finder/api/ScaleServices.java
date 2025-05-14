package note.finder.api;

import note.finder.entity.MusicalScale;
import note.finder.persistence.GenericDao;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scales")
public class ScaleServices {

    GenericDao dao;

    /**
     * retrieves all scales and their foreign key references
     * @return json array of scale objects and references
     */
    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {

        dao = new GenericDao<>(MusicalScale.class);
        List<MusicalScale> scales = dao.getAllWithFK(MusicalScale.class, "foreignKey");
        return Response.status(200).entity(scales).build();
    }


    /**
     * updates a scale
     * @param id id parameter of scale to be updated
     * @param updatedScale scale object to be updated and merged
     * @return
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateScale(@PathParam("id") int id, MusicalScale updatedScale) {

        dao = new GenericDao<>(MusicalScale.class);
        updatedScale.setId(id);
        dao.update(updatedScale);
        return Response.status(200).entity("{\"message\": \"Scale updated successfully\"}").build();
    }

    /**
     * creates a new scale
     * @param scale scale object to be inserted
     * @return json response 201 - confirmation
     */
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createScale(MusicalScale scale) {
        dao = new GenericDao<>(MusicalScale.class);
        dao.insert(scale);
        return Response.status(201).entity("{\"message\": \"Scale created successfully\"}").build();
    }


    /**
     * deletes a scale
     * @param id id of scale to be deleted
     * @return json 200 response - confirmation
     */
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteCategory(@PathParam("id") int id) {
        dao = new GenericDao<>(MusicalScale.class);
        dao.delete(MusicalScale.class, id);
        return Response.status(200).entity("{\"message\": \"Scale deleted successfully\"}").build();
    }
}