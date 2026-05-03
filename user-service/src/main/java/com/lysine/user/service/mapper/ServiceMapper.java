package com.lysine.user.service.mapper;

import com.lysine.model.*;
import com.lysine.user.model.Account;
import com.lysine.user.model.UserGroup;
import java.util.UUID;
import org.mapstruct.*;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ServiceMapper {


  @Mapping(target = "passwordHash", ignore = true) // hashed in service
  @Mapping(target = "role", ignore = true) // set separately if needed
  Account toEntity(AccountCreateRequestDto dto);

  @Mapping(target = "password", ignore = true) // never map hash back to plain-text field
  AccountCreateRequestDto toAccountCreateRequestDto(Account entity);

  // never map hash back to plain-text field
  AccountResponseDto toAccountResponseDto(Account entity);

  // For PATCH updates — only overwrite non-null fields
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "passwordHash", ignore = true)
  void updateEntityFromDto(AccountUpdateRequestDto dto, @MappingTarget Account account);

  UserGroup toUserGroupEntity(UserGroupCreateRequestDto userGroupCreateRequestDto);

  UserGroupResponseDto toUserGroupDto(UserGroup userGroup);


  // Wrap: String → JsonNullable<String>  ← this is what MapStruct needs
  default JsonNullable<String> toJsonNullable(String value) {
    return JsonNullable.of(value);
  }
  // Unwrap JsonNullable<String>
  default String fromJsonNullable(JsonNullable<String> value) {
    return (value != null && value.isPresent()) ? value.get() : null;
  }

  // Unwrap JsonNullable<UUID> → String
  default String fromJsonNullableUUID(JsonNullable<UUID> value) {
    if (value == null || !value.isPresent()) return null;
    return value.get() != null ? value.get().toString() : null;
  }

  // Hash password during toEntity mapping
  @Named("hashPassword")
  default String hashPassword(String plainTextPassword) {
    if (plainTextPassword == null) return null;
    return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
  }
}
