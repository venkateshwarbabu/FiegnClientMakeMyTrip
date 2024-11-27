package com.mmt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.feignservice.IrctcFeignClientCommun;
import com.mmt.model.PassengerModel;
import com.mmt.model.TicketModel;

@RestController
@RequestMapping("/makymytrip")
public class MainController {
	
	private IrctcFeignClientCommun irctcFeignClientCommun;


	public MainController(IrctcFeignClientCommun irctcFeignClientCommun) {
		this.irctcFeignClientCommun = irctcFeignClientCommun;
	}
	
	@PostMapping("/booktickets")
	public ResponseEntity<TicketModel> bookTicket(@RequestBody PassengerModel passengerModel){
		return irctcFeignClientCommun.bookTicket(passengerModel);
	}
	
	@GetMapping("/ticket/pnr/{ticketPnr}")
	public ResponseEntity<TicketModel> getTicketByPnr(@PathVariable String ticketPnr){
		return irctcFeignClientCommun.getTicketByPnr(ticketPnr);
	}

	@GetMapping("/ticket/id/{ticketId}")
	public ResponseEntity<TicketModel> getTicketById(@PathVariable Integer ticketId){
		return irctcFeignClientCommun.getTicketById(ticketId);
	}

	@GetMapping("/ticket/allTickets")
	public ResponseEntity<List<TicketModel>> getAllTickets(){
		return irctcFeignClientCommun.getAllTickets();
	}
	
	@PutMapping("/ticket/update/id/{ticketId}")
	public ResponseEntity<TicketModel> updateTicket(@RequestBody PassengerModel passengerModel,@PathVariable Integer ticketId){
		return irctcFeignClientCommun.updateTicket(passengerModel, ticketId);
	}
	
	@DeleteMapping("/ticket/delete/id/{ticketId}")
	public ResponseEntity<String> deleteTicketByTicketId(@PathVariable Integer ticketID){
		return irctcFeignClientCommun.deleteTicketByTicketId(ticketID);
	}
	
	@DeleteMapping("/ticket/deleteAllTickets")
	public ResponseEntity<String> deleteAllTicket(){
		return irctcFeignClientCommun.deleteAllTicket();
	}


}
