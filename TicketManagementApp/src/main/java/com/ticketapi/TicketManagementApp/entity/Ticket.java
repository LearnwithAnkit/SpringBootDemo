package com.ticketapi.TicketManagementApp.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "ticket_code", unique = true)
    private int ticketCode;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "status", length = 20)
    private String status;
}
