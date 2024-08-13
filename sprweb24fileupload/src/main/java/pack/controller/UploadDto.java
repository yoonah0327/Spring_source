package pack.controller;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadDto {
	private String myName;
	private MultipartFile myFile;
	//등록일 등 기타는 생략
}
