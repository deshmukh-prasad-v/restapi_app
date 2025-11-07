package mssu.in.restapi_app.entity;

public class Ticket {
	private Integer id;
	private String issue;
	private String raisedOn;
	private String issueType;
	private Priority priority;
	private Severity severity;
	
	public Ticket() {}
	public Ticket(Integer id, String issue, String raisedOn, String issueType, Priority priority, Severity severity) {
		super();
		this.id = id;
		this.issue = issue;
		this.raisedOn = raisedOn;
		this.issueType = issueType;
		this.priority = priority;
		this.severity = severity;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getRaisedOn() {
		return raisedOn;
	}
	public void setRaisedOn(String raisedOn) {
		this.raisedOn = raisedOn;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", issue=" + issue + ", raisedOn=" + raisedOn + ", issueType=" + issueType
				+ ", priority=" + priority + ", severity=" + severity + "]";
	}
}