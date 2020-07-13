package com.springbootdemo.ticketsystem.service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.springbootdemo.ticketsystem.entity.Ticket;
import com.springbootdemo.ticketsystem.repository.TicketRepository;
import com.springbootdemo.ticketsystem.repository.UserRepository;
import com.springbootdemo.ticketsystem.security.MyUserDetails;


@Service
public class TicketService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketService.class);
	
	@Autowired
	private TicketRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Cacheable(value="ticketCache")
	public List<Ticket> listAll() {		
		return repo.findAll();
	}
	
	@CacheEvict(value = "ticketCache", allEntries=true)
	public void save(Ticket ticket) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ticket.setCreatedOn(LocalDateTime.now());
		ticket.setOpenedBy(userRepo.getUserByUsername(((MyUserDetails)auth.getPrincipal()).getUsername()));
		repo.save(ticket);
		LOGGER.info(MessageFormat.format("Ticket has been created/Updated {0}", ticket.getId()));
	}
	
	public Ticket get(Long id) {
		return repo.findById(id).get();
	}
	
	@CacheEvict(value = "ticketCache",allEntries=true)
	public void delete(Long id) {
		repo.deleteById(id);
		LOGGER.info(MessageFormat.format("Ticket has been deleted {0}", id));
	}
}
