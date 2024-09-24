package com.mobpro.mobpro_internal.service.work;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Service
public class PadGeneration {

    @Autowired
    private HttpSession httpSession;

    private Date day;
    private Integer month;
    private Integer year;
    private String abrev;
    private Integer increm;
    private String numPAD;

    private String getDate(){
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        String dateString = day+""+ month +""+ year;
        return dateString;
    }

    private String getAbreviaton(){
        var user = currentUserDetails();
        return user.getUsername().substring(0,3).toUpperCase();
    }

    public String getNumPAD(){
        Random random = new Random();
        String numPAD = getDate() + getAbreviaton() + random.nextInt(1000, 9999);
        return numPAD;
    }

    public static UserDetails currentUserDetails(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            return principal instanceof UserDetails ? (UserDetails) principal : null;
        }
        return null;
    }

}
