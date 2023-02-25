package kr.goldenmine.inuminecraftlauncher.request.models.minecraft;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MinecraftLoginResponse {
    @SerializedName("username")
    String userName;

    @SerializedName("roles")
    List<String> roles;

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("token_type")
    String tokenType;

    @SerializedName("expires_in")
    int expiresIn;

    @Override
    public String toString() {
        return "MinecraftLoginResponse{" +
                "userName='" + userName + '\'' +
                ", roles=" + roles +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}