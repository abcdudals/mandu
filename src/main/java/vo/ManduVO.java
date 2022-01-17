package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ManduVO {
	private String id;
	private String password;
	private String name;
	private String myImage;
	private MultipartFile myImagef;
}
