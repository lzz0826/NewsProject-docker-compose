package tw.tony.com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.tony.com.mapper.AccountMapper;
import tw.tony.com.po.Account;


@Controller
public class UserController {
	
	@Autowired
    private AccountMapper accountMapper;

	@ResponseBody
	@PostMapping(value = "API_login")
	public String loginUserByAjax(@RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password) {
		return null;
			
	}
	
	@ResponseBody
	@GetMapping(value = "API_getAccout")
	public String getAccout() {
        List<Account> accountList = accountMapper.selectList(null);
		return null;
			
	}
	
	
	
}
