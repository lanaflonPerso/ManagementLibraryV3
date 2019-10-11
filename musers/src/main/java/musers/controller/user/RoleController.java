package musers.controller.user;



import musers.exceptions.ResourceNotFoundException;
import musers.model.user.Role;
import musers.service.user.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/all")
    public List<Role> roleList(){

        List<Role> roleList = roleService.findAll();
        if (roleList.isEmpty()) throw new ResourceNotFoundException( "Aucun role trouvé");

        return roleList;
    }


}
