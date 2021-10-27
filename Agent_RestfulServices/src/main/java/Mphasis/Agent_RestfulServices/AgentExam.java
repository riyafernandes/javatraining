package Mphasis.Agent_RestfulServices;

public class AgentExam {
private int agentID;
private String name;
private String city;
private String gender;
private int martialStatus;
private double premium;
public int getAgentID() {
	return agentID;
}
public void setAgentID(int agentID) {
	this.agentID = agentID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getMartialStatus() {
	return martialStatus;
}
public void setMartialStatus(int martialStatus) {
	this.martialStatus = martialStatus;
}
public double getPremium() {
	return premium;
}
public void setPremium(double premium) {
	this.premium = premium;
}
@Override
public String toString() {
	return "AgentExam [agentID=" + agentID + ", name=" + name + ", city=" + city + ", gender=" + gender
			+ ", martialStatus=" + martialStatus + ", premium=" + premium + "]";
}


}
