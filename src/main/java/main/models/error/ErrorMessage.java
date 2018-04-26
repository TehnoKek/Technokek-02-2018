package main.models.error;

public class ErrorMessage {

    private Integer code;
    private String text;

    public ErrorMessage(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ErrorMessage other = (ErrorMessage)obj;
        if (!other.code.equals(this.code))
            return false;
        if (!other.text.equals(this.text))
            return false;
        return true;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
