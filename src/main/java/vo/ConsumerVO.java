package vo;

import lombok.Data;

@Data
public class ConsumerVO {
	private String buyNo;
	private String itemNo;
	private String id;
	private String buyAddress;
	private String buyReview;
	private String buyImage;
	private String buyDate;
	private int buyStar;
}
