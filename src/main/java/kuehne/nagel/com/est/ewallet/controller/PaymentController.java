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

import kuehne.nagel.com.est.ewallet.form.PaymentForm;
import kuehne.nagel.com.est.ewallet.service.PaymentService;
import kuehne.nagel.com.est.ewallet.to.PaymentTO; 

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaymentTO> registerWithdraw(@RequestBody @Valid PaymentForm paymentForm, UriComponentsBuilder uriBuilder) {
		PaymentTO payment = paymentService.registerPayment(paymentForm);
		URI uri = uriBuilder.path("/payment/{code}").buildAndExpand(payment.getCode()).toUri();
		return ResponseEntity.created(uri).body(payment);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<PaymentTO> detailPayment(@PathVariable String code) {
		return Optional
				.ofNullable( paymentService.detailPayment(code))
				.map( payment -> ResponseEntity.ok().body(payment) )        
				.orElseGet( () -> ResponseEntity.notFound().build() );
	}

}
