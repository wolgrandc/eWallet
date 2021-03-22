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

import kuehne.nagel.com.est.ewallet.form.DepositForm;
import kuehne.nagel.com.est.ewallet.service.DepositService;
import kuehne.nagel.com.est.ewallet.to.DepositTO;

@RestController
@RequestMapping("/deposit")
public class DepositController {
	
	@Autowired
	DepositService depositService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DepositTO> registerWithdraw(@RequestBody @Valid DepositForm depositForm, UriComponentsBuilder uriBuilder) {
		DepositTO deposit = depositService.registerDeposit(depositForm);
		URI uri = uriBuilder.path("/deposit/{code}").buildAndExpand(deposit.getCode()).toUri();
		return ResponseEntity.created(uri).body(deposit);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<DepositTO> detailPayment(@PathVariable String code) {
		return Optional
				.ofNullable(depositService.detailDeposit(code))
				.map( deposit -> ResponseEntity.ok().body(deposit) )        
				.orElseGet( () -> ResponseEntity.notFound().build() );
	}

}
