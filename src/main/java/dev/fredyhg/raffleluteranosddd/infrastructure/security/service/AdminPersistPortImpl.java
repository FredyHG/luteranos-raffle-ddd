package dev.fredyhg.raffleluteranosddd.infrastructure.security.service;

import dev.fredyhg.raffleluteranosddd.common.exception.AdminUsernameAlreadyTakenException;
import dev.fredyhg.raffleluteranosddd.common.mapper.AdminMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.domain.ports.AdminPersistPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.repository.AdminRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AdminPersistPortImpl implements AdminPersistPort {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Admin save(Admin admin) {

        if(adminRepository.findByUsername(admin.getUsername()).isPresent()) {
            throw new AdminUsernameAlreadyTakenException("Username already taken");
        }

        AdminModel adminModel = AdminMapper.toModel(admin);

        adminModel.setPassword(passwordEncoder.encode(adminModel.getPassword()));

        AdminModel savedAdmin = adminRepository.save(adminModel);

        return AdminMapper.modelToAdmin(savedAdmin);
    }
}
