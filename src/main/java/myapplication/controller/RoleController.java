package myapplication.controller;

import myapplication.model.Role;
import myapplication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/list")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable("id") Integer id) {
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoleById(@PathVariable("id") Integer id){
        roleService.deleteRoleById(id);
    }

    @PostMapping("/add")
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }

    @PutMapping("/update/{id}")
    public void updateRole(@RequestBody Role role, @PathVariable("id") Integer id){
        Role roleUpd = roleService.getRoleById(id);
        roleUpd.setName(role.getName());
        roleService.updateRoles(roleUpd);
    }

}
