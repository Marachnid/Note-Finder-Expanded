package note.finder.api;

import note.finder.entity.MusicalScale;
import note.finder.persistence.ScaleDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scales")
public class Services {

    ScaleDao scaleDao = new ScaleDao();

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {
        List<MusicalScale> patterns = scaleDao.getAllScales();
        return Response.status(200).entity(patterns).build();
    }

}