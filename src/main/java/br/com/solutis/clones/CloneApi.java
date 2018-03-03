package br.com.solutis.clones;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("clones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CloneApi {
    
    private final CloneServico cloneServico = CloneServico.getInstance();
    
    @GET
    @POST
    @Path("/")
    public Response getClones() {
        List<Clone> clones = this.cloneServico.getClones();
        System.out.println("CloneApi.getClones() " + clones);
        return Response.ok().entity(clones).build();
    }
    
    @GET
    @POST
    @Path("/{nome}/{idade}/criar")
    public Response criarClone(@PathParam("nome") String nome, @PathParam("idade") int idade) {
        System.out.println("CloneApi.criarClone() " + nome + "-" + idade);
        this.cloneServico.criarClone(nome, idade);
        return Response.ok().build();
    }
    
    @GET
    @POST
    @Path("/{nome}/remover")
    public Response removerClone(@PathParam("nome") String nome) {
        System.out.println("CloneApi.removerClone() " + nome);
        this.cloneServico.removerClone(nome);
        return Response.ok().build();
    }
    
    @GET
    @POST
    @Path("/{nome}/{idade}/atualizar")
    public Response atualizarClone(@PathParam("nome") String nome, @PathParam("idade") int idade) {
        System.out.println("CloneApi.atualizarClone() " + nome + "-" + idade);
        this.cloneServico.atualizarClone(nome, idade);
        return Response.ok().build();
    }
    
}
