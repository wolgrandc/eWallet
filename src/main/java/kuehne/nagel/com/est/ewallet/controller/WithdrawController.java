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

import kuehne.nagel.com.est.ewallet.form.WithdrawForm;
import kuehne.nagel.com.est.ewallet.service.WithdrawService;
import kuehne.nagel.com.est.ewallet.to.WithdrawTO;

@RestController
@RequestMapping("/withdraw")
public class WithdrawController {
	
	@Autowired
	WithdrawService withdrawService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<WithdrawTO> registerWithdraw(@RequestBody @Valid WithdrawForm withdrawForm, UriComponentsBuilder uriBuilder) {
		WithdrawTO withdraw = withdrawService.registerWithdraw(withdrawForm);
		URI uri = uriBuilder.path("/withdraw/{code}").buildAndExpand(withdraw.getCode()).toUri();
		return ResponseEntity.created(uri).body(withdraw);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<WithdrawTO> detailWithdraw(@PathVariable String code) {
		return Optional
	            .ofNullable( withdrawService.detailWithdraw(code) )
	            .map( withdraw -> ResponseEntity.ok().body(withdraw) )        
	            .orElseGet( () -> ResponseEntity.notFound().build() );
	}

}
