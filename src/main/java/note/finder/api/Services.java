package note.finder.api;

import note.finder.entity.MusicalScale;
import note.finder.persistence.NoteFinderDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scales")
public class Services {

    NoteFinderDao<MusicalScale> scaleDao;


    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllScales() {

        scaleDao = new NoteFinderDao<>(MusicalScale.class);

        List<MusicalScale> patterns = scaleDao.getAll();

        return Response.status(200).entity(patterns).build();
    }
}