package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.clones;
import dao.UsuarioDAO;

/**
 * Servlet implementation class usuarioControlador
 */
@WebServlet("/clonesControlador")
public class clonesControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
	private static String INSERT = "/cadastrarCLONE.jsp";
	private static String LOGGER2 = "/RECADASTROCLONE.jsp";
	private static String EDIT = "/attCLONE.jsp";
    private static String LIST = "/listarCLONE.jsp"; 
    private static String LIST2 = "/listarCLONE2.jsp"; 
    private static String LOGGER = "/MENU.jsp"; 
    private static String ADD = "/ADICIONADO.html"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clonesControlador() {
        super();
        System.out.println("teste");
        dao = new UsuarioDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String forward="";
		        String action = request.getParameter("action");

		        if (action.equalsIgnoreCase("delete")){
		        	
		        	clones clones = new clones();
		        	int idClone = Integer.parseInt(request.getParameter("idClone"));
		        	clones.setIdClone(idClone);
		            dao.remover(clones);
		            forward = LIST;
		            request.setAttribute("clones", dao.getListaclones());
		            
		        } 
		        
		        
		      
		        else if (action.equalsIgnoreCase("edit")){
		        	
		        	forward = EDIT;
		            
		        	int idClone = Integer.parseInt(request.getParameter("idClone"));
		            clones clones = dao.obterclones(idClone);
		            
		            request.setAttribute("clones", clones);
		            
		        } 
 
		        
		        
		        
		        
		    	else if (action.equalsIgnoreCase("listou")) {
					
					 RequestDispatcher view = request.getRequestDispatcher(LIST);
				        request.setAttribute("clones", dao.getListaclones());
				        view.forward(request, response);
				}
				
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        else if (action.equalsIgnoreCase("listarclones")){
		            
		        	forward = LIST;
		            request.setAttribute("clones", dao.getListaclones());
		            
		        } else {
		        	
		            forward = INSERT;
		        }

		        RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
		    
		        
		        


		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
	}
	
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clones  clones= new clones();
		String action = request.getParameter("action");
		String forward=""; 
		
	
		if (action.equalsIgnoreCase("port")){
			   
			
			
			
			 String  nome =(request.getParameter("nome"));
			 String  skill =(request.getParameter("skill"));
			 String idClone = request.getParameter("idClone");
			 String  idade =(request.getParameter("idade"));
			 String  criacao =(request.getParameter("criacao"));
			 String genero = request.getParameter("genero");
			 String especial = request.getParameter("especial");
			 System.out.println(especial);
			 System.out.println(skill);

	     	   request.setAttribute("clones", dao.pesquisa(nome, skill, idClone, idade, criacao, genero, especial));
      	
             
             
             
        	 if(clones.getNome() == null || clones.getNome().isEmpty())
     	    {  
        		 
        		 System.out.println("TA ERRADA");
 	            System.out.println("TA ERRADA");
 	            RequestDispatcher view = request.getRequestDispatcher(LIST2);

 		        view.forward(request, response); 
     	    }
        	
        	 else{
            RequestDispatcher view = request.getRequestDispatcher(LIST2);
          
	        view.forward(request, response);
        	 }
        	 
        	 

        	 
        }
		
	
		else if(action.equalsIgnoreCase("edic")){
			
			String Skill = request.getParameter("skill");
			clones.setSkill(Skill);
			
			int idade = Integer.parseInt(request.getParameter("idade"));
			clones.setIdade(idade);
			
			String criacao = request.getParameter("criacao");
			clones.setCriacao(criacao);
			
			String genero = request.getParameter("genero");
			clones.setGenero(genero);
			
			String especial = request.getParameter("especial");
			clones.setEspecial(especial);
			
			
			String idClone = request.getParameter("idClone");
			 if(idClone == null || idClone.isEmpty())
		    {
		            dao.adicionar(clones);
		    }
		    else
		    {
		            clones.setIdClone(Integer.parseInt(idClone));
		            dao.alterar(clones);
		    }
			
			
		        RequestDispatcher view = request.getRequestDispatcher(LIST);
			       
		        request.setAttribute("clones", dao.getListaclones());
		        view.forward(request, response);
			
			
		}
		
		
		
		
		   else if (action.equalsIgnoreCase("cad")) {
			   String  nomes =(request.getParameter("nome"));
	        	 clones = dao.obterinfo(nomes);
	             request.setAttribute("clones", clones);
	             
	             
	             
				 if(clones.getNome() == null || clones.getNome().isEmpty() ){
		String nome = request.getParameter("nome");
		nome=nome.toUpperCase();
		clones.setNome(nome);
		
		String Skill = request.getParameter("skill");
		clones.setSkill(Skill);
		
		int idade = Integer.parseInt(request.getParameter("idade"));
		clones.setIdade(idade);
		
		String criacao = request.getParameter("criacao");
		clones.setCriacao(criacao);
		
		String genero = request.getParameter("genero");
		clones.setGenero(genero);
		
		String especial = request.getParameter("especial");
		clones.setEspecial(especial);
		
		
		String idClone = request.getParameter("idClone");
		 if(idClone == null || idClone.isEmpty())
	    {
	            dao.adicionar(clones);
	    }
	    else
	    {
	            clones.setIdClone(Integer.parseInt(idClone));
	            dao.alterar(clones);
	    }
		
 
	        RequestDispatcher view = request.getRequestDispatcher(ADD);
	       
	        request.setAttribute("clones", dao.getListaclones());
	        view.forward(request, response);
		
	}else{
					    RequestDispatcher view = request.getRequestDispatcher(LOGGER2);
				       
				        view.forward(request, response);
				 }
	}
	}

	
}
