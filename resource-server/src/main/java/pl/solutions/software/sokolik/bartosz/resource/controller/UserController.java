package pl.solutions.software.sokolik.bartosz.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/role/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String roleUserContent() {
        return "role user content";
    }

    @GetMapping("/authority/user")
    @PreAuthorize("hasAuthority('READ_ONLY')")
    public String authorityUserContent() {
        return "authority user content";
    }

    @GetMapping("/role/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String roleAdminContent() {
        return "role admin content";
    }

    @GetMapping("/authority/admin")
    @PreAuthorize("hasAuthority('READ_WRITE')")
    public String authorityAdminContent() {
        return "authority admin content";
    }
}
