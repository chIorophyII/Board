//package com.example.testproject;
//
//import com.example.board.login.repository.UserRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = { ApplicationConfig.class, MvcConfig.class })
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    public void testGetUserByUsername() {
//        String genUser = "test1";
//        String adminUser = "testadmin1";
//
//        String password = passwordEncoder.encode("password");
//
//        UserRole genRole = UserRole.USER;
//        UserRole adminRole = UserRole.ADMIN;
//
//        Integer code = 1234;
//
//        User genTest = new User(genUser, password, genRole, code);
//        User adminTest = new User(adminUser, password, adminRole, null);
//        userRepository.save(genTest);
//        userRepository.save(adminTest);
//
//        User user = userRepository.findByUsername("test1").get();
//        User admin = userRepository.findByUsername("testadmin1").get();
//        // OPTIONAL 사용으로 null 체크 불필요
////        Users notUser = userRepository.findByUsername("없는아이디");
////        Assert.assertNull(notUser);
//        Assert.assertNotNull(user);
//        Assert.assertNotNull(admin);
////
////        userRepository.delete(user);
////        Users deleteUser = userRepository.findByUsername("genUser").get();
////        Assert.assertNull(deleteUser);
//    }
//}
