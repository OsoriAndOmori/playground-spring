package com.osori.mvc.controller

import com.osori.mvc.custom.AccountContext
import com.osori.mvc.service.AccountService
import com.osori.mvc.service.FormSampleService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import java.security.Principal

@Controller
class FormController (private val formSampleService: FormSampleService, private val accountService: AccountService) {
    @GetMapping("/")
    fun index(principal: Principal?): ModelAndView {
        val mv = ModelAndView("index")
        if (principal == null) {
            mv.addObject("message", "Hello Spring Security index")
        } else {
            mv.addObject("message", "Hello Spring Security index, " + principal.getName())
        }
        return mv
    }

    @GetMapping("/info")
    fun info(): ModelAndView {
        return ModelAndView("info")
            .addObject("message", "info")
    }

    @GetMapping("/dashboard")
    fun dashboard(principal: Principal): ModelAndView {
        AccountContext.setAccount(accountService.loadUserByUsername(principal.getName()))
        formSampleService.dashboard()
        return ModelAndView("dashboard")
            .addObject("message", "Hello, " + principal.getName())
    }

    @GetMapping("/admin")
    fun admin(admin: Principal?): ModelAndView {
        return ModelAndView("admin")
            .addObject("message", "Hello Spring Security")
    }
}