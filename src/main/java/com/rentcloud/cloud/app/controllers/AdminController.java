/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Admin;
import com.rentcloud.cloud.app.services.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
// anotacion que indica que este es un controlador 
@RestController
// indicar que contexto me va a administrar este controlador (admin)Admin
@RequestMapping("Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    
    
    @Autowired
    // me genere un objeto
    private AdminService service;
    
    /**
     * GET
     * @return 
     */
    // indico con que metodo voy a acceder y la url necesita /all
    @GetMapping("/all")
    //metodo que me devuelve una lista de administradores
    public List<Admin> getAdmins(){
        return service.getAll();
    }
    
    /**
     * GET/{id}
     * @param adminId
     * @return 
     */
    // me obtenga ell elemento por el id y lo obtiene como un parametro con la anotacion 
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int adminId){
        return service.getAdmin(adminId);
    }
    
    /**
     * POST
     * @param admin
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin admin){
        return service.save(admin);
    }
    
    /**
     * PUT
     * @param admin
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update (@RequestBody Admin admin){
        return service.update(admin);
    }
    
    /**
     * DELETE
     * @param admin
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean delete (@PathVariable("id") int adminId){
        return service.delete(adminId);
    }
}
