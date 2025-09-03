package com.ada.ronaldo.controller;

import com.ada.ronaldo.domain.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zina")
public class zinaController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getOneProductByID(@PathVariable String id){
        if(id.equals("ronaldo") || id.equals("Ronaldo")){
            return ResponseEntity.ok("Brilha muito no curitia");
        }else if(id.equals("C topa ir comigo nessa fita ai")||id.equals("c topa ir comigo nessa fita ai")){
            return ResponseEntity.ok("Topo, topo, porque não? Vamo cair pra dentro!");
        }else {
            return ResponseEntity.ok("Eu num tindi uq ele falô");
        }
    }


}
