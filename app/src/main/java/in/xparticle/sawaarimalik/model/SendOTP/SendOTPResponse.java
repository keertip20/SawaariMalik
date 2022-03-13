package in.xparticle.sawaarimalik.model.SendOTP;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SendOTPResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    private String msg;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("userTypeCode")
    @Expose
    private Integer userTypeCode;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(Integer userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

}
