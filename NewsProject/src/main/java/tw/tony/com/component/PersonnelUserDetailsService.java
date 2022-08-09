package tw.tony.com.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import tw.tony.com.mapper.AccountMapper;
import tw.tony.com.po.Account;

public class PersonnelUserDetailsService  implements UserDetailsService {

	@Autowired
	private AccountMapper accountMapper;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

		System.out.println("account"+account);
		Map<String, Object> map =  accountMapper.selectMapByUsetname(account);
		System.out.println(map.get("username"));
		System.out.println("username"+map.get("username"));
		System.out.println("password"+map.get("password"));
		System.out.println("permission"+map.get("permission"));
		if(map == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
//		String coding =  bCryptPasswordEncoder.encode("123456");
//		System.out.println("coding"+coding);
//		boolean check=  bCryptPasswordEncoder.matches("123456", accountBean.getPassword());
//		System.out.println("check: "+check);
		
		UserDetails userDetails = User.builder()
				.username(map.get("username").toString())
				.password(map.get("password").toString())
				.roles(map.get("permission").toString()).build();

		System.out.println("userDetails"+userDetails);

		
		
		return userDetails;
	}

}
