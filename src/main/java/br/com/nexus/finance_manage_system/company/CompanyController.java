package br.com.nexus.finance_manage_system.company;

import br.com.nexus.finance_manage_system.dto.CompanyRequestDTO;
import br.com.nexus.finance_manage_system.dto.CompanyResponseDTO;
import br.com.nexus.finance_manage_system.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> createCompany(@RequestBody CompanyRequestDTO request, @AuthenticationPrincipal User user){
        return ResponseEntity.ok(this.companyService.createCompany(user, request));
    }
}
