package mssu.in.restapi_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mssu.in.restapi_app.entity.Ticket;
import mssu.in.restapi_app.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Ticket> getAllTickets(){
		return ticketRepository.getAllTickets();
	}
	
	public void addNewTicket(Ticket ticket) {
		ticketRepository.addNewTicket(ticket);
	}
	
	public void deleteTicket(Integer id){
		ticketRepository.deleteTicket(id);
	}
	
	public void editTicket(Ticket ticket) {
		ticketRepository.editTicket(ticket);
	}
	
	public Ticket getTicketById(Integer id) {
		return ticketRepository.getTicketById(id);
	}
}
