package br.com.fiap.resource.processoSeletivo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/Desafio")
public class DesafioCandidatoResource {
	private DesafioCandidatoBO rbo = new DesafioCandidatoBO();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DesafioCandidatoTO> exibir() {
		return rbo.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DesafioCandidatoTO> exibir(@PathParam("id") int id) {
		return rbo.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(DesafioCandidatoTO dcto, @Context UriInfo uriInfo) {
		rbo.inserir(dcto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(dcto.getId()));
		return Response.created(builder.build()).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(DesafioCandidatoTO dcto, @PathParam("id") int id) {
		dcto.setId(id);
		rbo.alterar(dcto);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void deletar(@PathParam("id")int id) {
		rbo.deletar(id);
	}

}
