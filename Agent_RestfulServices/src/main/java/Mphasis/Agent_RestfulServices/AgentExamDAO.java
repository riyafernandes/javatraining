package Mphasis.Agent_RestfulServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentExamDAO {
	Connection connection;
	PreparedStatement pst;
	
	//Update Agent
	 public String updateAgentRecord(AgentExam agent) throws SQLException {
		 AgentExam agentfound=searchAgent(agent.getAgentID());
		 if(agentfound!=null) {
			 String cmd="Update AgentExam set Name=?, City=?, GENDER=?, MaritalStatus=?, Premium=? "
					     +" where AgentID=?";
			 connection=ConnectionHelper.getConnection();
			 pst=connection.prepareStatement(cmd);
			    //pst.setInt(1, agent.getAgentID());
				pst.setString(1, agent.getName());
				pst.setString(2, agent.getCity());
				pst.setString(3, agent.getGender());
				pst.setInt(4, agent.getMartialStatus());
				pst.setDouble(5, agent.getPremium());
				pst.setInt(6, agent.getAgentID());
                pst.executeUpdate();
				return "Record Updated Sucessfully";
		 }
		 return "Record Not Found";
		 }
	 
	
	
	//Delete Agent
	public String deleteAgent(int agentID) throws SQLException {
		AgentExam agent=searchAgent(agentID);
		if(agent!=null) {
			connection=ConnectionHelper.getConnection();
			String cmd="Delete from AgentExam where AgentID=?";
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, agentID);
			pst.executeUpdate();
			return "Record Deleted";
		}
		return "Record Not Found";
	}
	
	
	
	//Show all Agent records
	public AgentExam[] showAgent() throws SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="select * from AgentExam";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<AgentExam> agentList=new ArrayList<AgentExam>();
		AgentExam agent=null;
		while(rs.next()) {
			agent=new AgentExam();
			agent.setAgentID(rs.getInt("AgentID"));
			agent.setName(rs.getString("Name"));
			agent.setCity(rs.getString("City"));
			agent.setGender(rs.getString("GENDER"));
			agent.setMartialStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("Premium"));
			agentList.add(agent);
		}
		return agentList.toArray(new AgentExam[agentList.size()]);
		
	}
	
	//Search Agent
	public AgentExam searchAgent(int agentID) throws SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd="select * from AgentExam where AgentID=?";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, agentID);
		ResultSet rs=pst.executeQuery();
		AgentExam agent=null;
		if(rs.next()) {
			agent=new AgentExam();
			agent.setAgentID(rs.getInt("AgentID"));
			agent.setName(rs.getString("Name"));
			agent.setCity(rs.getString("City"));
			agent.setGender(rs.getString("GENDER"));
			agent.setMartialStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("Premium"));
		}
		return agent;
	}
	
	
	
	//Generate agentID automatically
	public int generateAgentId() throws SQLException{
		
		connection=ConnectionHelper.getConnection();
		String cmd="select case when max(agentID) is NULL"
				+" then 1 else max(agentID)+1 end agnid from AgentExam";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int agentId=rs.getInt("agnid");
		return agentId;
		
	}
	// Add a Agent Record
	public String addAgentRecord(AgentExam agent) throws SQLException {
		int agnid=generateAgentId();
		agent.setAgentID(agnid);
		connection=ConnectionHelper.getConnection();
		String cmd="Insert into AgentExam(AgentID,Name,City,GENDER,MaritalStatus,Premium)"
				    +"values(?,?,?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, agnid);
		//pst.setInt(1,agent.getAgentID()); used if Agent Id is not generated automatically
		pst.setString(2, agent.getName());
		pst.setString(3, agent.getCity() );
		pst.setString(4, agent.getGender());
		pst.setInt(5, agent.getMartialStatus());
		pst.setDouble(6, agent.getPremium());
		pst.executeUpdate();
		return "Agent Record Created Successfully";
	}
}
