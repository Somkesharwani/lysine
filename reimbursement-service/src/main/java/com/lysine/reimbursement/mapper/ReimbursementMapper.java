package com.lysine.reimbursement.mapper;

import com.lysine.model.ReimbursementDocumentDto;
import com.lysine.model.ReimbursementDto;
import com.lysine.reimbursement.model.Reimbursement;
import com.lysine.reimbursement.model.ReimbursementDocument;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReimbursementMapper {

  ReimbursementDto toDto(Reimbursement entity);

  @Mapping(target = "file", ignore = true)
  @Mapping(target = "reimbursementId", source = "reimbursement.id")
  ReimbursementDocumentDto toDto(ReimbursementDocument entity);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Reimbursement toEntity(ReimbursementDto dto);

  @BeanMapping(ignoreUnmappedSourceProperties = {"file"})
  @Mapping(target = "reimbursement", ignore = true)
  @Mapping(target = "filePath", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  ReimbursementDocument toEntity(ReimbursementDocumentDto dto);

  default String map(org.springframework.core.io.Resource file) {
    return file == null ? null : file.getFilename();
  }
}
