package Mphasis.Agent_RestfulServices;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agent")
public class AgentService {
	//Delete agent
	@POST
	@Path("/deleteagent/{agentID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
public String deleteAgent(@PathParam("agentID") int agentID) throws SQLException{
	AgentExamDAO dao=new AgentExamDAO();
	return dao.deleteAgent(agentID);
}
	
	//Update agent
		@POST
		@Path("/updateagent")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
	public String updateAgentRecord(AgentExam agent) throws SQLException{
		AgentExamDAO dao=new AgentExamDAO();
		return dao.updateAgentRecord(agent);
	}
	
	//Add agent
	@POST
	@Path("/addagent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
public String addAgentRecord(AgentExam agent) throws SQLException{
	AgentExamDAO dao=new AgentExamDAO();
	return dao.addAgentRecord(agent);
}
	
	//search agent
	@GET
	@Path("/searchagent/{agentID}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public AgentExam searchAgent(@PathParam("agentID") int agentID) throws SQLException {
		AgentExamDAO dao=new AgentExamDAO();
		AgentExam agent=dao.searchAgent(agentID);
		return agent;
	}
	
	//Show all	
	@GET
	@Path("/showagent")
	@Produces(MediaType.APPLICATION_JSON)
	public AgentExam[] showAgent() throws SQLException {
		AgentExamDAO dao=new AgentExamDAO();
		AgentExam[] agent=dao.showAgent();
		return agent;
	}
}
