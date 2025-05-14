package note.finder.api;

import note.finder.entity.MusicalCategory;
import note.finder.entity.MusicalScale;
import note.finder.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/services")
public class Services {

    GenericDao dao = new GenericDao();

    /**
     * retrieves all scales and their foreign key references
     * @return json array of scale objects and references
     */
    @GET
    @Path("/scales")
    @Produces("application/json")
    public Response getAllScales() {

        List<MusicalScale> scales = dao.getAllWithFK(MusicalScale.class, "foreignKey");
        return Response.status(200).entity(scales).build();
    }

    /**
     * retrieves all patterns without foreign key references
     * @return json array of category objects without references
     */
    @GET
    @Path("/categories")
    @Produces("application/json")
    public Response getAllCategories() {

        List<MusicalCategory> categories = dao.getAllWithoutFK(MusicalCategory.class);
        return Response.status(200).entity(categories).build();
    }


}