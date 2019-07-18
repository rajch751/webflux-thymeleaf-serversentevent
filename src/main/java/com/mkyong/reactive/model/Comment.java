package com.mkyong.reactive.model;

public class Comment {

    private String author;
    private String message;
    private String closed;
    private String total;
    private String timestamp;

    public Comment(String author,String message, String closed,String total,String timestamp) {
        this.author = author;
        this.message = message;
        this.timestamp = timestamp;
        this.closed=closed;
        this.total=String.valueOf((Integer.parseInt(message)+Integer.parseInt(closed)));
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", message=" + message + ", closed=" + closed + ", total=" + total
				+ ", timestamp=" + timestamp + "]";
	}

   
   
}
