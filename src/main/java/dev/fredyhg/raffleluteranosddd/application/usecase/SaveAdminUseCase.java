package dev.fredyhg.raffleluteranosddd.application.usecase;

import dev.fredyhg.raffleluteranosddd.common.mapper.AdminMapper;
import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.domain.ports.RequestAdminReceiverPort;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AdminPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveAdminUseCase {

    private final RequestAdminReceiverPort requestAdminReceiverPort;

    public Admin createAdmin(AdminPostRequest adminPostRequest) {

        Admin adminToSave = AdminMapper.toAdmin(adminPostRequest);

        return requestAdminReceiverPort.save(adminToSave);
    }
}
