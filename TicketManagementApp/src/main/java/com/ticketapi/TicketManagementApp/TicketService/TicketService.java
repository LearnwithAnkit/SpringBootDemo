package com.ticketapi.TicketManagementApp.TicketService;


import com.ticketapi.TicketManagementApp.ResponseHandler;
import com.ticketapi.TicketManagementApp.TicketRepository.TicketRepository;
import com.ticketapi.TicketManagementApp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ResponseEntity<?> getAllTickets() {
        try {
            List<Ticket> tickets = ticketRepository.findAll();
            return ResponseHandler.generateResponse("Successfully Retrieved Data", HttpStatus.OK, tickets);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK, null);
        }
    }


    public ResponseEntity<?> getTicketById(Integer id) {
        try {
            Ticket ticket = ticketRepository.findById(id).orElse(null);
            if (ticket != null)
                return ResponseHandler.generateResponse("Successfully Retrieved Ticket", HttpStatus.OK, ticket);
            else
                return ResponseHandler.generateResponse("Ticket not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public ResponseEntity<Object> createTicket(Ticket ticket) {
        try {

            return ResponseHandler.generateResponse("Successfully Added Ticket", HttpStatus.CREATED, ticketRepository.save(ticket));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public ResponseEntity<Object> updateTicket(Integer id, Ticket updatedTicket) {

        try {

            Ticket existingTicket = ticketRepository.findById(id).orElse(null);
            return ResponseHandler.generateResponse("Successfully Updated Ticket", HttpStatus.OK, ticketRepository.save(updatedTicket));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Unable to Update the Ticket", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    public ResponseEntity<String> deleteTicket(Integer id) {
        try {
            ticketRepository.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ticket Not Found", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> getPaginatedTickets(Pageable pageable) {
        try {
            Page<Ticket> tickets = ticketRepository.findAll(pageable);
            return ResponseHandler.generateResponse("Successfully Retrieved Data", HttpStatus.OK, tickets.getContent());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }
}
