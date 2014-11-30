package movieSearch;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieSearch.model.Movie;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FindMovies
 */
@WebServlet("/FindMovies")
public class FindMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMovies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("findMovies.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movie = request.getParameter("movie");
		
		URL url = new URL("http://www.omdbapi.com/?s=" + URLEncoder.encode(movie, "UTF-8") + "&y=&plot=short&r=json");
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(url, Map.class);
		
		List list = (List)map.get("Search");
		if (list != null) {
			
			List<Movie> movies = new ArrayList<Movie>();
			
			for (Object item : list)
			{
			      Map<String, Object> innerMap = (Map<String, Object>)item;
			      
			      movies.add(new Movie((String)innerMap.get("Title"), (String)innerMap.get("Year")));
			      
	//		      for (String key : innerMap.keySet())
	//		      {
	//		            System.out.println(key + ": " + innerMap.get(key));
	//		      }
			}
			request.getSession().setAttribute("movies", movies);
		}
		
		response.sendRedirect("FindMovies");
	}

}
