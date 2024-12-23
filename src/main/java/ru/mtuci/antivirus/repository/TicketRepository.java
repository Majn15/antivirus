package ru.mtuci.antivirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.antivirus.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
