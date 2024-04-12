package com.example.demo.service;
import com.example.demo.Model.AuthenticationResult;
import com.example.demo.Model.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.demo.config.UserSecurityController;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
@Service
@Transactional
public class AccountService {

    @Autowired
    private UserMapper userMapper;
    public AuthenticationResult select(MyUser user) {
        List<MyUser> userInfo;
        try{
            userInfo = userMapper.select(user);
            // 유저 정보가 존재하지 않을 경우 처리
            if(userInfo == null || userInfo.isEmpty()) {
                // 예외 처리 또는 사용자에게 메시지 전달 등
                return new AuthenticationResult(false, null);
            }
            // 데이터베이스에서 불러온 비밀번호
            String dbHashedPassword = userInfo.get(0).getPASSWORD();
            // 사용자가 입력한 비밀번호를 해시화
            String userInputPassword = user.getPASSWORD();
            String userEnteredHashedPassword = UserSecurityController.hashPassword(userInputPassword);
            // 해시 값 비교
            if (dbHashedPassword.equals(userEnteredHashedPassword)) {
                // 사용자 정보 생성
                String username = userInfo.get(0).getUSER_NM();
                String password = userInfo.get(0).getPASSWORD(); // 실제 비밀번호를 가져옴

                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
                if (authorities == null || authorities.isEmpty()) {
                    throw new IllegalArgumentException("Authorities cannot be null or empty.");
                }
                UserDetails userDetails = new User(username, password,authorities);
                String token = UserSecurityController.generateToken(userDetails); // 예시: 유저명을 토큰의 서브젝트로 사용
                return new AuthenticationResult(true, token);
            } else {
                return new AuthenticationResult(false, null);
            }
        }catch (Exception e){
            return new AuthenticationResult(false, null);

        }

    }
    public List<MyUser> findId(MyUser user) {
        return userMapper.findId(user);
    }
    public List<MyUser> findPw(MyUser user) {
        return userMapper.findPw(user);
    }
    public void insert(MyUser user){
        // 비밀번호 해시화
        String hashedPassword = UserSecurityController.hashPassword(user.getPASSWORD());
        user.setPASSWORD(hashedPassword);
        userMapper.insert(user);
    }


}
