package kr.goldenmine.inuminecraftlauncher.auth;

import kr.goldenmine.inuminecraftlauncher.request.MicrosoftServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

//@EnableWebMvc
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    public static CompletableFuture<String> future = new CompletableFuture<>();

//    @RequestMapping(
//            value = "/authorization",
//            method = RequestMethod.GET
//    )
//    public ResponseEntity<?> authorization(
//            final HttpServletRequest req,
//            final HttpServletResponse res,
//            @RequestParam Map<String,String> allRequestParams) throws Exception {
//
//        String code = allRequestParams.get("code");
//        String state = allRequestParams.get("state");
//        String error = allRequestParams.get("error");
//        String errorDescription = allRequestParams.get("error_description");
//
//        System.out.println(code);
//        System.out.println(state);
//        System.out.println(error);
//        System.out.println(errorDescription);
//
//        return ResponseEntity.ok("");
//    }

    @RequestMapping(
            value = "/microsoft",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> authMicrosoft(@RequestParam Map<String,String> allRequestParams) throws Exception {
        String code = allRequestParams.get("code");
//        String state = allRequestParams.get("state");
        String idToken = allRequestParams.get("id_token");
        String error = allRequestParams.get("error");
        String errorDescription = allRequestParams.get("error_description");

        if(error == null
//                && MicrosoftServiceImpl.state.equals(state)
        ) {
            log.info("code: " + code);
//            log.info("state: " + state);
            log.info("token: " + idToken);

            future.complete(code);

            return ResponseEntity.ok("authorization succeed.");
        } else {
            log.warn(error);
            log.warn(errorDescription);
            log.warn("original state: " + MicrosoftServiceImpl.state);
//            log.warn("state: " + state);

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error + "\n" + errorDescription);
        }
    }
}
