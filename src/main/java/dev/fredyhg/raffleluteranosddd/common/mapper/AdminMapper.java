package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.infrastructure.http.request.AdminPostRequest;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;

public class AdminMapper {
    public static AdminModel toModel(Admin admin) {
        return new AdminModel(admin.getPassword(),
                admin.getUsername(),
                admin.getRole());
    }

    public static Admin modelToAdmin(AdminModel adminModel) {
        return new Admin(adminModel.getId(),
                adminModel.getUsername(),
                adminModel.getPassword());
    }

    public static Admin toAdmin(AdminPostRequest adminPostRequest) {
        return new Admin(adminPostRequest.getUsername(), adminPostRequest.getPassword());
    }
}
