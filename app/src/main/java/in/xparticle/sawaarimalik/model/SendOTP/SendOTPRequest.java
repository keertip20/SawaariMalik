package in.xparticle.sawaarimalik.model.SendOTP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendOTPRequest {

    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("userTypeCode")
    @Expose
    private Integer userTypeCode;

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