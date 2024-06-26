package aze.coders.springjpaadvanced.controller;

import aze.coders.springjpaadvanced.model.CustomerDto;
import aze.coders.springjpaadvanced.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @SneakyThrows
    public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(customerService.getAllCustomers(name));
    }

}
