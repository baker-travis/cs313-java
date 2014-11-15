package forum;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.Post;
import forum.model.PostDataHandler;

/**
 * Servlet implementation class ShowPosts
 */
@WebServlet("/ShowPosts")
public class ShowPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPosts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostDataHandler handler = new PostDataHandler("posts.txt");
		
		request.setAttribute("posts", handler.getPosts());
		
		request.getRequestDispatcher("viewPosts.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostDataHandler handler = new PostDataHandler("posts.txt");
		
		handler.addPost(new Post((String) request.getSession().getAttribute("username"), new Date(), request.getParameter("post"))); 
		
		request.setAttribute("posts", handler.getPosts());
		
		request.getRequestDispatcher("viewPosts.jsp").forward(request,response);
	}

}
