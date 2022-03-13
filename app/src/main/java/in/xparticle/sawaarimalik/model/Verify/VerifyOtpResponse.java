package in.xparticle.sawaarimalik.model.Verify;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VerifyOtpResponse {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("newUser")
    @Expose
    private Boolean newUser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Boolean getNewUser() {
        return newUser;
    }

    public void setNewUser(Boolean newUser) {
        this.newUser = newUser;
    }


    public class User {

        @SerializedName("blockedBy")
        @Expose
        private String blockedBy;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("login_attempts")
        @Expose
        private Integer loginAttempts;
        @SerializedName("login_counts")
        @Expose
        private Integer loginCounts;
        @SerializedName("isBlocked")
        @Expose
        private Boolean isBlocked;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("userType")
        @Expose
        private UserType userType;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public String getBlockedBy() {
            return blockedBy;
        }

        public void setBlockedBy(String blockedBy) {
            this.blockedBy = blockedBy;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getLoginAttempts() {
            return loginAttempts;
        }

        public void setLoginAttempts(Integer loginAttempts) {
            this.loginAttempts = loginAttempts;
        }

        public Integer getLoginCounts() {
            return loginCounts;
        }

        public void setLoginCounts(Integer loginCounts) {
            this.loginCounts = loginCounts;
        }

        public Boolean getIsBlocked() {
            return isBlocked;
        }

        public void setIsBlocked(Boolean isBlocked) {
            this.isBlocked = isBlocked;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public UserType getUserType() {
            return userType;
        }

        public void setUserType(UserType userType) {
            this.userType = userType;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

    }

    public class UserType {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("type_code")
        @Expose
        private Integer typeCode;
        @SerializedName("type_description")
        @Expose
        private String typeDescription;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

    }

}