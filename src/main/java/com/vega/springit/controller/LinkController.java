package com.vega.springit.controller;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vega.springit.domains.Comment;
import com.vega.springit.domains.Link;
import com.vega.springit.repositorys.CommentRepository;

import com.vega.springit.service.LinkService;



@Controller
public class LinkController {
	private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
	
	private LinkService linkService;
	private CommentRepository commentRepository;


	
	public LinkController(LinkService linkService, CommentRepository commentRepository) {
		this.linkService = linkService;
		this.commentRepository = commentRepository;
	}

	//CRUD
	@PostMapping("/create")
	public Link create(@ModelAttribute Link link) {
		return linkService.save(link);
	}
	
	@GetMapping("/{id}")
	public Optional<Link> read(@PathVariable Long id) {
		return linkService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Link update(@ModelAttribute Link link) {
		return linkService.save(link);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		linkService.deleteById(id);
	}
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("links",linkService.findAll());
		return "links/list";
	}
	
	@GetMapping("/link/{id}")
	public String read(@PathVariable Long id,Model model) {
		Optional<Link> link=linkService.findById(id);
		
		if(link.isPresent()) {
			Link currentLink=link.get();
			Comment comment=new Comment();
			comment.setLink(currentLink);
			model.addAttribute("comment", comment);
			model.addAttribute("link", currentLink);
			model.addAttribute("success",model.containsAttribute("success"));
			return "links/view";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "links/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
    	
    	if(bindingResult.hasErrors()) {
    		logger.info("Validation errors were found while submitting a new link.");
    		model.addAttribute("link",link);
    		return "links/submit";
    	}else {
    		//save your link
    		linkService.save(link);
    		logger.info("New link was saved successfuly!");
    		redirectAttributes.addAttribute("id",link.getId())
    		.addFlashAttribute("success", true);
    		
    		return "redirect:/link/{id}";
    	}
        
    }
    
    @Secured({"ROLE_USER"})
    @PostMapping("link/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		logger.info("There was a problem to register the comment!");
    	}else {
    		commentRepository.save(comment);
    		logger.info("The comment was saved successfully.");
    	}
    	return "redirect:/link/"+comment.getLink().getId();
    }

	
}
