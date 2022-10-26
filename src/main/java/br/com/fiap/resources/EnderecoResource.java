package br.com.fiap.resources;

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

import candidato.EnderecoBO;
import candidato.EnderecoTO;

@Path("/endereco")
public class EnderecoResource {

	private EnderecoBO rbo = new EnderecoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoTO> exibir() {
		return rbo.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoTO> exibir(@PathParam("id") int id) {
		return rbo.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EnderecoTO endereco, @Context UriInfo uriInfo) {
		rbo.inserir(endereco);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(endereco.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(EnderecoTO endereco, @PathParam("id") int id) {
		endereco.setId(id);
		rbo.atualizar(endereco);
		return Response.ok().build();

	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		rbo.deletar(id);
	}

}
