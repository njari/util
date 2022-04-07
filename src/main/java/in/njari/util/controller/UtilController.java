package in.njari.util.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilController {
    @GetMapping("/util")
    public ResponseEntity<?> f(){
        return new ResponseEntity<>("I provide insights.", HttpStatus.OK);
    }
}
