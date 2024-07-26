package dev.fredyhg.raffleluteranosddd.common.mapper;

import dev.fredyhg.raffleluteranosddd.domain.models.admin.Admin;
import dev.fredyhg.raffleluteranosddd.domain.models.security.admintoken.AdminToken;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminModel;
import dev.fredyhg.raffleluteranosddd.infrastructure.security.persist.model.AdminTokenModel;

public class AdminTokenMapper {

    public static AdminTokenModel toModel(AdminToken adminToken, AdminModel adminModel) {
        return new AdminTokenModel(
                adminToken.getId().fromValue(),
                adminToken.getToken(),
                adminToken.getTokenType(),
                adminModel);
    }

    public static AdminToken modelToAdmin(AdminTokenModel adminTokenModel, Admin admin) {
        return new AdminToken(
                adminTokenModel.getId(),
                adminTokenModel.getToken(),
                admin,
                adminTokenModel.isRevoked(),
                adminTokenModel.isExpired());
    }

}
