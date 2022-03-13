package in.xparticle.sawaarimalik.model.Verify;

import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpRequest {

    @SerializedName("otp")
    @Expose
    private Integer otp;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("userTypeCode")
    @Expose
    private Integer userTypeCode;

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(Integer userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

}