package tw.tony.com.vo;


public class ResponseData<T> {
	
	
	private T data;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMagmessage() {
		return magmessage;
	}

	public void setMagmessage(String magmessage) {
		this.magmessage = magmessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String magmessage;
	
	private String code;

	@Override
	public String toString() {
		return "ResponseData [data=" + data + ", magmessage=" + magmessage + ", code=" + code + "]";
	}
	
	

	
	
}
