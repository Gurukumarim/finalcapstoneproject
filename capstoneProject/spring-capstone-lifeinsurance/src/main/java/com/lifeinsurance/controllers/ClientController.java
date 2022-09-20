package com.lifeinsurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifeinsurance.model.Client;
import com.lifeinsurance.service.IClientService;

@CrossOrigin("http://localhost:4200")
@RestController
public class ClientController {

	@Autowired
	IClientService clientService;
	
	@PostMapping("/client")
	public ResponseEntity<Void> addClient(@RequestBody Client client) {
		 clientService.addClient(client);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/client")
	public ResponseEntity<Void> updateClient(Client client){
		clientService.updateClient(client);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	@DeleteMapping("/client/{clientId}")
	public ResponseEntity<String> deleteClient(@PathVariable("clientId")  int clientId){
		clientService.deleteClient(clientId);
		return ResponseEntity.accepted().body("Updated");
	}
	
	
	@GetMapping("/client")
	public ResponseEntity<List<Client>> getAll(){
		List<Client> clients=clientService.getAll();
		ResponseEntity<List<Client>> responseEntity=new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/client/name/{clientName}")
	public ResponseEntity<List<Client>> getByName(@PathVariable("clientName") String clientName) {
		List<Client> clients=clientService.getByName(clientName);
		ResponseEntity<List<Client>> responseEntity=new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/client/id/{clientId}")
	public ResponseEntity<List<Client>> getById(@PathVariable("clientId") int clientId){
		List<Client> clients= clientService.getById(clientId);
		ResponseEntity<List<Client>> responseEntity=new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/client/name/{clientName}/id/{clientId}")
	public ResponseEntity<List<Client>> getByNameAndId(@PathVariable("clientName") String clientName,@PathVariable("clientId") int clientyId){
		List<Client> clients=clientService.getByNameAndId(clientName, clientyId);
		ResponseEntity<List<Client>> responseEntity=new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/client/id/{clientId}/nominee/{nomineeName}")
	public ResponseEntity<List<Client>> getByIdAndNominee(@PathVariable("clientId") int clientId,@PathVariable("nomineeName") String nomineeName){
		List<Client> clients=clientService.getByIdAndNominee(clientId, nomineeName);
		ResponseEntity<List<Client>> responseEntity=new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
		return responseEntity;
		
	}
	
	
}
