//package tw.tony.com.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//import tw.tony.com.mapper.AccountMapper;
//import tw.tony.com.po.Account;
//
//public class PersonnelUserDetailsService  implements UserDetailsService {
//
//	@Autowired
//	private AccountMapper accountMapper;
//	
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
//		Account accountBean = accountDao.findAccountByEId(account);
//		System.out.println("geteID"+accountBean.geteID());
//		System.out.println("getPassword"+accountBean.getPassword());
//		if(accountBean == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		
////		String coding =  bCryptPasswordEncoder.encode("123456");
////		
////		System.out.println("coding"+coding);
////		
////		boolean check=  bCryptPasswordEncoder.matches("123456", accountBean.getPassword());
////		
////		System.out.println("check: "+check);
//		
//		UserDetails userDetails = User.builder()
//				.username(accountBean.geteID())
//				.password(accountBean.getPassword())
//				.roles(accountBean.getPurview()).build();
//		
////		loginRecordDao.insertLoginRecord(accountBean.geteID(), accountBean.getEmpName());
//		
//		
//
//		System.out.println("userDetails"+userDetails);
//
//		
//		
//		return userDetails;
//	}
//
//}
