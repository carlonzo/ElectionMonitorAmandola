package it.carlom.amandolaelezioni;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/")
public class ApiManager {

	Elezioni elezioni;

	public ApiManager() {
		elezioni = Elezioni.getElezioni();

		System.out.println("elezioni creato");
	}

	@POST
	@Path("/updatesezione")
	@Produces("application/json")
	public Response updateSezione(@Context HttpServletRequest req, Sezione newsezione) {

		try {

			int number = newsezione.getNumber();

			for (Sezione sez : elezioni.sezioni) {
				if (sez.getNumber() == number) {

					sez.setLista1(newsezione.getLista1());
					sez.setLista2(newsezione.getLista2());
					sez.setLista3(newsezione.getLista3());

					elezioni.updateTime();
					return Response.ok(elezioni.sezioni).build();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Path("/getsezioni")
	@Produces("application/json")
	public Response getSezione() {

		try {

			return Response.ok(elezioni.sezioni).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

}
