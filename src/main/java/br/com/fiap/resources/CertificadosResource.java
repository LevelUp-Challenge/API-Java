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

import candidato.CertificadosBO;
import candidato.CertificadosTO;

@Path("certificados")
public class CertificadosResource {
	
private CertificadosBO rbo = new CertificadosBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CertificadosTO> exibir() {
		return rbo.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CertificadosTO> exibir(@PathParam("id") int id) {
		return rbo.listar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CertificadosTO certificados, @Context UriInfo uriInfo) {
		rbo.inserir(certificados);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(certificados.getIdCertificados()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CertificadosTO certificados, @PathParam("id") int id) {
		certificados.setIdCertificados(id);
		rbo.atualizar(certificados);
		return Response.ok().build();
		
	}
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		rbo.deletar(id);
	}
	
	
	

}
