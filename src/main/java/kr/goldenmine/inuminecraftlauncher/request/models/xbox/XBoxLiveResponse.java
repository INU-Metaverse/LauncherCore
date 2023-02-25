package kr.goldenmine.inuminecraftlauncher.request.models.xbox;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class XBoxLiveResponse extends MicrosoftErrorResponse {
    @SerializedName("IssueInstant")
    String issueInstant;

    @SerializedName("NotAfter")
    String notAfter;

    @SerializedName("Token")
    String token;

    @SerializedName("DisplayClaims")
    XBoxLiveResponseDisplayClaims displayClaims;

    @Override
    public String toString() {
        return "XBoxLiveResponse{" +
                "issueInstant='" + issueInstant + '\'' +
                ", notAfter='" + notAfter + '\'' +
                ", token='" + token + '\'' +
                ", displayClaims=" + displayClaims +
                '}';
    }
}