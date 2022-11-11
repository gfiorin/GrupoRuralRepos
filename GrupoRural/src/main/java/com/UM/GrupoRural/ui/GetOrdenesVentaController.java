package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.OrderMgr;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/GetOrdenesVenta")
@CrossOrigin("*")
public class GetOrdenesVentaController {
    @Autowired
    OrderMgr orderMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrdenesVenta() throws IOException {
        return ResponseEntity.ok(orderMgr.getAllOrdenesVenta());
    }
}
