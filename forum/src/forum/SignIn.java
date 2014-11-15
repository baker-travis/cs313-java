package forum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
        
        File file = new File("forumUsers.txt");
        try {
			if (!file.exists()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write("avengers stark\ntest me\nthor asgard\n");
				System.out.println("wrote to file");
				writer.close();
			} else {
				System.out.println("file exists or is not empty");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
            BufferedReader reader = new BufferedReader(new FileReader("forumUsers.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(" ");
            	if (username.equals(parts[0]) && password.equals(parts[1])) {
            		request.getSession().setAttribute("username", username);
            		response.sendRedirect("newPost.jsp");
            		reader.close();
        			return;
            	}
            }
            
            reader.close();

		} catch (IOException e) {
			e.printStackTrace();
       	}
		response.sendRedirect("invalid.jsp");
	}

}
