package br.com.bank.payments.controller;

import br.com.bank.payments.dto.PaymentRecordDto;
import br.com.bank.payments.entity.Payment;
import br.com.bank.payments.repository.PaymentRepository;
import br.com.bank.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<Payment> create(@RequestBody @Valid PaymentRecordDto paymentRecordDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(paymentRecordDto));
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments(){
        var paymentsList = paymentRepository.findAll();
        if(!paymentsList.isEmpty()) {
            for(var payment : paymentsList) {
                var id = payment.getIdPayment();
                payment.add(linkTo(methodOn(PaymentController.class).getOnePayment(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(paymentsList);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Object> getOnePayment(@PathVariable(value="id") UUID id){
        var paymentO = paymentRepository.findById(id);
        if(paymentO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found.");
        }
        paymentO.get().add(linkTo(methodOn(PaymentController.class).getAllPayments()).withRel("Payments List"));
        return ResponseEntity.status(HttpStatus.OK).body(paymentO.get());
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Object> deletePayment(@PathVariable(value="id") UUID id) {
        var paymentO = paymentRepository.findById(id);
        if(paymentO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found.");
        }
        paymentService.deleteLogicPayment(paymentO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Payment deleted successfully.");
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<Object> updatePayment(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid PaymentRecordDto paymentRecordDto) {
        var paymentO = paymentRepository.findById(id);
        if(paymentO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found.");
        }
        var payment = paymentO.get();
        BeanUtils.copyProperties(paymentRecordDto, payment);
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.save(payment));
    }
}
