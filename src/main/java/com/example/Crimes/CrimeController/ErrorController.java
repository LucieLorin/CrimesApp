package com.example.Crimes.CrimeController;

import com.example.Crimes.CrimeService.ErrorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final ErrorService errorService;

    /**
     * @deprecated
     * TODO vyresit jinak, nez pres servlet
     */
    @RequestMapping("/error")
    public String error(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            return statusCode + "! " + "Web je momentálně nefunkční. DŮVOD: " + errorService.getExcuse();
        }
        return "Web je momentálně nefunkční. DŮVOD: " + errorService.getExcuse();
    }
}
