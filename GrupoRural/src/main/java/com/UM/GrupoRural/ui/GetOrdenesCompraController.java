package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.OrderMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/GetOrdenesCompra")
@CrossOrigin("*")
public class GetOrdenesCompraController {
    @Autowired
    OrderMgr orderMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrdenesCompra() throws IOException {
        return ResponseEntity.ok(orderMgr.getAllOrdenesCompra());
    }
}
