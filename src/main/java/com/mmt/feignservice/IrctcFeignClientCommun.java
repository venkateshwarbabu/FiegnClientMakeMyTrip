package com.mmt.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mmt.model.PassengerModel;
import com.mmt.model.TicketModel;


@FeignClient(name="IRCTCMINI")
public interface IrctcFeignClientCommun {
	
	@PostMapping("/irctc/bookTicket")
	public ResponseEntity<TicketModel> bookTicket(@RequestBody PassengerModel passengerModel);
	
	@GetMapping("/irctc/ticket/pnr/{ticketPnr}")
	public ResponseEntity<TicketModel> getTicketByPnr(@PathVariable String ticketPnr);

	@GetMapping("/irctc/ticket/id/{ticketId}")
	public ResponseEntity<TicketModel> getTicketById(@PathVariable Integer ticketId);

	@GetMapping("/irctc/ticket/allTickets")
	public ResponseEntity<List<TicketModel>> getAllTickets();
	
	@PutMapping("/irctc/ticket/update/id/{ticketId}")
	public ResponseEntity<TicketModel> updateTicket(@RequestBody PassengerModel passengerModel,@PathVariable Integer ticketId);
	
	@DeleteMapping("/irctc/ticket/delete/id/{ticketId}")
	public ResponseEntity<String> deleteTicketByTicketId(@PathVariable Integer ticketID);
	
	@DeleteMapping("/irctc/ticket/deleteAllTickets")
	public ResponseEntity<String> deleteAllTicket();


}
