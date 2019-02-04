package base;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@Path("/")
public class ScoreService extends Application{

	// GET	
	@GET @Path("/score/wins")@Produces("application/json")
	public int getWins() {return Score.WINS;}
	     
	@GET @Path("/score/losses")@Produces("application/json")
	public int getLosses() {return Score.LOSSES;}
	     
	@GET @Path("/score/ties")@Produces("application/json")
	public int getTies() {return Score.TIES;}
	
	// INCREASE
	@POST @Path("/score/wins")@Produces("application/json")
	public int increaseWins() { return Score.WINS++; }
	     
	@POST @Path("/score/ties")@Produces("application/json")   
	public int increaseTies() { return Score.TIES++;}
	     
	@POST @Path("/score/losses")@Produces("application/json")         
	public int increaseLosses() {return Score.LOSSES++;}
	
	
	@GET
	@Path("/score")
	@Produces("application/json")
	public String getScore() {
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES );   
	}
	 
	@PUT
	@Path("/score")
	@Produces("application/json")
	public String update(@QueryParam("wins") int wins, 
	                        @QueryParam("losses") int losses, 
	                        @QueryParam("ties")   int ties) {
	   Score.WINS   = wins;
	   Score.TIES   = ties;
	   Score.LOSSES = losses;
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES );   
	}
}
