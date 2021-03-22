package kuehne.nagel.com.est.ewallet.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kuehne.nagel.com.est.ewallet.form.TransferForm;
import kuehne.nagel.com.est.ewallet.service.TransferService;
import kuehne.nagel.com.est.ewallet.to.TransferTO;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	TransferService transferService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<TransferTO> registerTransfer(@RequestBody @Valid TransferForm transferForm, UriComponentsBuilder uriBuilder) {
		TransferTO transfer = transferService.registerTransfer(transferForm); 
		URI uri = uriBuilder.path("/transfer/{code}").buildAndExpand(transfer.getCode()).toUri();
		return ResponseEntity.created(uri).body(transfer);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<TransferTO> detailTransfer(@PathVariable String code) {
		return Optional
				.ofNullable( transferService.detailTransfer(code))
				.map( transfer -> ResponseEntity.ok().body(transfer) )        
				.orElseGet( () -> ResponseEntity.notFound().build() );
	}

}
