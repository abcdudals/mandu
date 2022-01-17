package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SellerVO {
	private String itemNo;
	private String id;
	private String itemTitle;
	private String itemContent;
	private int itemPrice;
	private String itemImage;
	private MultipartFile itemImagef;
	private String itemDate;
	private int buyCount;
	private int itemCount;
	private String itemType;
}
