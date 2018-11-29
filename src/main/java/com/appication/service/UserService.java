package com.appication.service;

import com.appication.mapper.UserRepository;
import com.appication.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser() {
        Optional<User> _user = userRepository.findById(1);
        User user = _user.get();
        return user;
    }

    public User addUser() {
        User user = new User();
        user.setId(2);
        user.setName("guiling");
        user.setCreateTime(new Date());
        user.setDepartmentId("2");
        userRepository.save(user);
        return user;
    }
    public List<User> getUserPage() {
        PageRequest pageRequest = new PageRequest(0, 20);
        Page<User> userPage = userRepository.findAll(pageRequest);
        //查询出总数据条数
        long totalElements = userPage.getTotalElements();
        //查询出总的页数
        int totalPages = userPage.getTotalPages();
        List<User> listUser = userPage.getContent();
        return listUser;
    }
}
