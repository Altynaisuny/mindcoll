package com.sunyt.mindcoll.dao.repository;

import com.sunyt.mindcoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 查询
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 登陆查询
     * @param username
     * @param password
     * @return
     */
    List<User> findByUsernameAndPassword(String username, String password);
}
