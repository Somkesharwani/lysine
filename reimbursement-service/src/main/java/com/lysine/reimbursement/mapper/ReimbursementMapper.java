package com.lysine.reimbursement.mapper;

import com.lysine.model.ReimbursementDocumentDto;
import com.lysine.model.ReimbursementDto;
import com.lysine.reimbursement.model.Reimbursement;
import com.lysine.reimbursement.model.ReimbursementDocument;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
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
  @Mapping(
      target = "filePath",
      expression = "java(saveFileAndGetPath(dto.getFile(), dto.getLabel()))")
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  ReimbursementDocument toEntity(ReimbursementDocumentDto dto);

  default String saveFileAndGetPath(org.springframework.core.io.Resource file, String label) {
    if (file == null) {
      return null;
    }

    try {
      String uploadDir = "/uploads/reimbursements";
      String originalFilename = file.getFilename();
      String objectName = label + "_" + System.currentTimeMillis() + "_" + originalFilename;
      String filePath = uploadDir + "/" + objectName;

      // Create directory if not exists
      Files.createDirectories(Paths.get(uploadDir));

      // Save file to server
      Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

      return filePath;
    } catch (IOException e) {
      throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
    }
  }
}
