package com.example.projecttraining.restController;

import com.example.projecttraining.dto.OrderDTO;
import com.example.projecttraining.model.Account;
import com.example.projecttraining.service.account.IAccountService;
import com.example.projecttraining.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
public class OrderRestController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IAccountService accountService;

    private Account getAccountLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String accountNameLogin = authentication.getName();
            Account account = accountService.findByAccountName(accountNameLogin);
            return account;
        }
        return null;
    }


    @PostMapping("/store")
    public Map<String, List<String>> storeOrders(@RequestBody List<OrderDTO> data) {
        Map<String, List<String>> errorsList = new OrderDTO().validate(data);
        if (errorsList.isEmpty()) {
            Account account = getAccountLogin();
            int rowEffect = orderService.insertAndUpdateOrders(account.getAccountId(), data);
        }
        return errorsList;
    }
}
