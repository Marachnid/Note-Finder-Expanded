package note.finder.api;

import note.finder.entity.MusicalScale;
import note.finder.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scales")
public class Services {

    GenericDao dao = new GenericDao();

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {


        List<MusicalScale> scales = dao.getAllWithForeignEntity(MusicalScale.class, "foreignKey");
        return Response.status(200).entity(scales).build();


    }

}