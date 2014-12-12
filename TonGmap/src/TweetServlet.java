

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.JSONObject;



/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/TweetServlet")

public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.io.PrintWriter write = response.getWriter();
		String query = request.getParameter("query");
		System.out.println(query);
		try {
			JSONObject tweetjson = fetchTweet.maintweets(query);
			request.setAttribute("tweetjson", tweetjson);
			request.getRequestDispatcher("map.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in geenrating json");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
