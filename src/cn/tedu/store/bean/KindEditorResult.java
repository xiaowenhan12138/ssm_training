package cn.tedu.store.bean;

public class KindEditorResult {
	
	private Integer error;// 0成功 1失败
	private String url;// 上传成功时路径
	private String message;// 上传失败时信息
	
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
