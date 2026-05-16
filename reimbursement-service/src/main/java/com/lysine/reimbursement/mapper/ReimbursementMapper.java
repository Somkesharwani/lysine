package com.lysine.reimbursement.mapper;

import com.lysine.model.ReimbursementDocumentDto;
import com.lysine.model.ReimbursementDto;
import com.lysine.model.ReimbursementResponseDto;
import com.lysine.reimbursement.model.Reimbursement;
import com.lysine.reimbursement.model.ReimbursementDocument;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReimbursementMapper {

  @Mapping(target = "submittedAt", ignore = true)
  @Mapping(target = "approvedAt", ignore = true)
  @Mapping(target = "documents", ignore = true)
  ReimbursementDto toDto(Reimbursement entity);

  @Mapping(target = "reimbursementId", source = "reimbursement.id")
  ReimbursementDocumentDto toDto(ReimbursementDocument entity);

  ReimbursementResponseDto toDtoWithDocuments(Reimbursement entity);

  @Mapping(target = "submittedAt", ignore = true)
  @Mapping(target = "approvedAt", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  Reimbursement toEntity(ReimbursementDto dto);

  // @BeanMapping(ignoreUnmappedSourceProperties = {"file"})
  @Mapping(target = "reimbursement", ignore = true)
  /*@Mapping(
  target = "filePath",
  expression = "java(saveFileAndGetPath(dto.getFile(), dto.getLabel()))")*/
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  ReimbursementDocument toEntity(ReimbursementDocumentDto dto);

  default String saveFileAndGetPath(
      org.springframework.web.multipart.MultipartFile file, String label) {
    if (file == null) {
      return null;
    }
    try {
      String uploadDir = "/uploads/reimbursements";
      String originalFilename = file.getOriginalFilename();
      String objectName = label + "_" + System.currentTimeMillis() + "_" + originalFilename;
      String filePath = uploadDir + "/" + objectName;
      Files.createDirectories(Paths.get(uploadDir));
      file.transferTo(Paths.get(filePath));
      return filePath;
    } catch (IOException e) {
      throw new RuntimeException("Failed to save file: " + e.getMessage(), e);
    }
  }
}
