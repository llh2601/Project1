package ca.nixa.project.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.nixa.project.model.Client;
import ca.nixa.project.repository.ClientRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;




@Controller
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	ClientRepository repo;
	
	@GetMapping("/rest")
	public List<Client> ListRest() {
        List<Client> clientList = (List<Client>) repo.findAll();
      
		return clientList;
	}
	@GetMapping("/findAll")
	public String List(Model model) {
        List<Client> clientList = (List<Client>) repo.findAll();
        model.addAttribute("clients", clientList);
		return "clients/clientsList";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idClient, Model model) {		
		java.util.Optional<Client> client = repo.findById(idClient);			
		model.addAttribute("client", client);
		
		return "clients/formClient";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idClient, RedirectAttributes attributes) {		
		
		
			repo.deleteById(idClient);	
		attributes.addFlashAttribute("msg", "Deleted!.");
		return "redirect:/clients/findAll";
		
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Client client) {
		
		return "clients/formClient";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Client client,Model model, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){	
			
			System.out.println("Errors");
			return "clients/formClient";
		}	
		
	
		repo.save(client);
		attributes.addFlashAttribute("msg", "saved!");		
		return "redirect:/clients/findAll";
	}
	
	
	
	
	
	
}
