package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.OrderMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/GetOrdenesVentaMenosUna/{ordenventa}")
@CrossOrigin("*")
public class GetOrdenesDeVentaMenosUnaController {
    @Autowired
    OrderMgr orderMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrdenesVentaMenosUna(@PathVariable("ordenventa") Integer idOrden) throws IOException {
        return ResponseEntity.ok(orderMgr.getAllOrdenesVentaMenosUna(idOrden));
    }

}
