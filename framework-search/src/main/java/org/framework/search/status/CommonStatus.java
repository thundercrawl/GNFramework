package org.framework.search.status;

public class CommonStatus<T> {

	private String message;
	private int StatusCode;
	private T result;
	
	

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return int return the StatusCode
     */
    public int getStatusCode() {
        return StatusCode;
    }

    /**
     * @param StatusCode the StatusCode to set
     */
    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

}
