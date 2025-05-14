package note.finder.api;

import note.finder.entity.MusicalCategory;
import note.finder.persistence.GenericDao;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
public class CategoryServices {

    GenericDao dao;

    /**
     * retrieves all patterns without foreign key references
     * @return json array of category objects without references
     */
    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllCategories() {

        dao = new GenericDao<>(MusicalCategory.class);
        List<MusicalCategory> categories = dao.getAllWithoutFK(MusicalCategory.class);
        return Response.status(200).entity(categories).build();
    }

    /**
     * updates a category
     * @param id id parameter of category object to be updated and merged
     * @param updatedCategory category object being updated
     * @return json response 200 - confirmation
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateCategory(@PathParam("id") int id, MusicalCategory updatedCategory) {
        dao = new GenericDao<>(MusicalCategory.class);
        updatedCategory.setId(id);
        dao.update(updatedCategory, id); // Pass ID to retrieve existing entity
        return Response.status(200).entity("{\"message\": \"Category updated successfully\"}").build();
    }


    /**
     * creates a new category
     * @param category category object to be inserted
     * @return json response 201 - confirmation
     */
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCategory(MusicalCategory category) {
        dao = new GenericDao<>(MusicalCategory.class);
        dao.insert(category);
        return Response.status(201).entity("{\"message\": \"Category created successfully\"}").build();
    }


    /**
     * deletes a category
     * @param id id of category to be deleted
     * @return json 200 response - confirmation
     */
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteCategory(@PathParam("id") int id) {
        dao = new GenericDao<>(MusicalCategory.class);
        dao.delete(MusicalCategory.class, id);
        return Response.status(200).entity("{\"message\": \"Category deleted successfully\"}").build();
    }





}
