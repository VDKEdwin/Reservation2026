
package be.edwin.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.edwin.pid.model.Role;
import be.edwin.pid.service.RoleService;

@Controller
public class RoleController {

    @Autowired
    RoleService service;

    @GetMapping("/roles")
    public String index(Model model) {
        List<Role> roles = service.getAll();

        model.addAttribute("roles", roles);
        model.addAttribute("title", "Liste des rôles");

        return "role/index";
    }

    @GetMapping("/roles/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Role role = service.get(id);

        model.addAttribute("role", role);
        model.addAttribute("title", "Fiche d'un rôle");

        return "role/show";
    }
}
