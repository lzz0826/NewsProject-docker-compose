package tw.tony.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.tony.com.mapper.AccountMapper;
import tw.tony.com.po.Account;

@Controller
@RequestMapping("/api/Account")
public class AccountController {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired 
	AccountMapper accountMapper;

	@ResponseBody
	@GetMapping(value = "/getAllAccount")
	public String getAllAccountDetailed() {
		
		List<Account> account = accountMapper.selectList(null);
		try {
			String resultString = objectMapper.writeValueAsString(account);
			return resultString;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	//單筆
	@ResponseBody
	@PostMapping(value = "/getAccountById")
	public String getAccountById(@RequestParam String id) {
		
		Account account = accountMapper.selectById(id);
		
		try {
			String resultString = objectMapper.writeValueAsString(account);
			return resultString;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	@ResponseBody
	@PostMapping(value = "/getAccountManyById")
	public String getAccountManyById(@RequestParam List<Integer> list) {
		
		List<Account> account = accountMapper.selectBatchIds(list);
		
		try {
			String resultString = objectMapper.writeValueAsString(account);
			return resultString;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}




}
