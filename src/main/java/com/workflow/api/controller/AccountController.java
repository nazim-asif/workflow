package com.workflow.api.controller;

import com.workflow.api.repository.schema.Account;
import com.workflow.api.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@RestController
@RequestMapping("api/accounts/")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("create")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }
}
