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

import recrutador.ContatoRecrutadorBO;
import recrutador.ContatoRecrutadorTO;

@Path("/contato-recrutador")
public class ContatoRecrutadorResource {
private ContatoRecrutadorBO rbo = new ContatoRecrutadorBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContatoRecrutadorTO> exibir() {
		return rbo.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContatoRecrutadorTO> exibir(@PathParam("id") int id) {
		return rbo.listar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ContatoRecrutadorTO cto, @Context UriInfo uriInfo) {
		rbo.inserir(cto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(cto.getId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(ContatoRecrutadorTO cto, @PathParam("id") int id) {
		rbo.atualizar(cto);
		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(ContatoRecrutadorTO cto, @PathParam("id") int id) {
		rbo.excluir(id);
	}

	

}
