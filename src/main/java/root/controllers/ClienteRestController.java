package root.controllers;

import org.springframework.web.bind.annotation.RestController;

import root.models.service.IClienteService;
import root.view.xml.ClienteList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClienteRestController
 */
@RestController
@RequestMapping(value = "/api/clientes", method = RequestMethod.GET)
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping(value = "/listar")
    public ClienteList listarRest() {

        return new ClienteList(clienteService.findAll());

    }

}