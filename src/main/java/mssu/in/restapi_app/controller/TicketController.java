package mssu.in.restapi_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mssu.in.restapi_app.entity.Ticket;
import mssu.in.restapi_app.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/get")
	public List<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	@PostMapping("/add")
	public void addNewTicket(@RequestBody Ticket ticket) {
		ticketService.addNewTicket(ticket);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTicket(@PathVariable Integer id) {
		ticketService.deleteTicket(id);
	}
	
	@PutMapping("/edit")
	public void editTicket(@RequestBody Ticket ticket) {
		ticketService.editTicket(ticket);
	}
	
	@GetMapping("/get/{id}")
	public Ticket getTicketById(@PathVariable Integer id) {
		return ticketService.getTicketById(id);
	}
}
