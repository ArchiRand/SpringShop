package soso.production.controller;

import soso.production.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("adminController")
public class AdminController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(value="/admin", method= RequestMethod.GET)
    public String getAdminPanel(Model model) {
        model.addAttribute("allReports", cartService.findAllCartReports());
        return "admin/admin";
    }
}
