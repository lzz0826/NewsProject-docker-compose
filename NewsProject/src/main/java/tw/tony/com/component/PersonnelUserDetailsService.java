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

		Map<String, Object> map =  accountMapper.selectMapByUsetname(account);
		if(map == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		UserDetails userDetails = User.builder()
				.username(map.get("username").toString())
				.password(map.get("password").toString())
				.roles(map.get("permission").toString()).build();

		
		return userDetails;
	}

}
