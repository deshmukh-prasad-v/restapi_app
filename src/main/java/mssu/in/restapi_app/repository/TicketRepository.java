package mssu.in.restapi_app.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mssu.in.restapi_app.entity.Priority;
import mssu.in.restapi_app.entity.Severity;
import mssu.in.restapi_app.entity.Ticket;

@SuppressWarnings("unused")
@Repository
public class TicketRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Ticket> getAllTickets() {
		 String sql = "select*from ticket";   
	     return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Ticket.class));

	     //use below code if field names and column names vary
//	     return jdbcTemplate.query(sql, (rs, rowNum) -> {
//	    	    Ticket ticket = new Ticket();
//	    	    ticket.setId(rs.getInt("id"));
//	    	    ticket.setIssue(rs.getString("issue"));
//	    	    ticket.setRaised_on(rs.getString("raisedOn"));
//	    	    ticket.setIssue_type(rs.getString("issueType"));
//	    	    ticket.setPriority(Priority.valueOf(rs.getString("priority")));
//	    	    ticket.setSeverity(Severity.valueOf(rs.getString("severity")));
//	    	    return ticket;
//	    	});                                      
	}
	
	public void addNewTicket(Ticket ticket) {
	    String sql = "insert into ticket(issue, raisedOn, issueType, priority, severity) values (?,?,?,?,?)";
	    jdbcTemplate.update(
	        sql,
	        ticket.getIssue(),
	        ticket.getRaisedOn(),
	        ticket.getIssueType(),
	        ticket.getPriority().name(),
	        ticket.getSeverity().name()
	    );
	}
	
	public void editTicket(Ticket ticket) {
		String sql="update ticket set issue=?, raisedOn=?, issueType=?, priority=?, severity=? where id=?";
		jdbcTemplate.update(
		        sql,
		        ticket.getIssue(),
		        ticket.getRaisedOn(),
		        ticket.getIssueType(),
		        ticket.getPriority().name(),
		        ticket.getSeverity().name(),
		        ticket.getId()
		    );
	}
	
//	public void editIssueType(Integer id, String issueType) {
//		String sql="update ticket set issueType=? where id=?";
//		jdbcTemplate.update(sql,issueType,id);
//	}
	
	public void deleteTicket(Integer id) {
		String sql="delete from ticket where id=?";
		jdbcTemplate.update(sql,id);
	}
	
	public Ticket getTicketById(Integer id) {
	    String sql = "select*from ticket where id = ?";
	    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Ticket.class), id);
	}

}