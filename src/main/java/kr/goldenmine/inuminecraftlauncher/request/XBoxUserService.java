package kr.goldenmine.inuminecraftlauncher.request;

import kr.goldenmine.inuminecraftlauncher.request.models.xbox.XBoxLiveRequest;
import kr.goldenmine.inuminecraftlauncher.request.models.xbox.XBoxLiveResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface XBoxUserService {
    /*
        https://user.auth.xboxlive.com/user/authenticate
     */
    @Headers({
            "Content-Type: application/json; charset=UTF-8",
            "Accept: application/json",
//            "charset: UTF-8"
    })
    @POST("user/authenticate")
    Call<XBoxLiveResponse> authenticate(@Body XBoxLiveRequest request);

}
