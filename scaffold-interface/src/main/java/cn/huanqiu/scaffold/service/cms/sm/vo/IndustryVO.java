package cn.huanqiu.scaffold.service.cms.sm.vo;

public class IndustryVO {
	
	
    public IndustryVO(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	private String id;
    
    private String text;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    
}
