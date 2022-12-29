package pl.engineerproject.pw.fifapp.mapper;

import pl.engineerproject.pw.fifapp.dto.RoleDto;
import pl.engineerproject.pw.fifapp.model.Role;

public class RoleMapper {

    public static Role dtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getRoleId());
        role.setRoleName(roleDto.getRoleName());
        return role;
    }

    public static RoleDto entityToDto(Role role) {
        return new RoleDto(role.getId(),role.getRoleName());
    }
}
