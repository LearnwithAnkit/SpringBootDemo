package com.ticketapi.TicketManagementApp.controller;

import com.ticketapi.TicketManagementApp.TicketService.TicketService;
import com.ticketapi.TicketManagementApp.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {
    @Autowired
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/paginated")
    public ResponseEntity<?> getPaginatedTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ticketService.getPaginatedTickets(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Integer id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping()
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTicket(@PathVariable int id, @RequestBody Ticket updatedTicket) {
        return ticketService.updateTicket(id, updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Integer id) {

        return ticketService.deleteTicket(id);
    }
}
