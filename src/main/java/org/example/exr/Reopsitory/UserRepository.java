package org.example.exr.Reopsitory;

import org.example.exr.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserById(Integer id);

    User findUserByUsernameAndPassword(String username, String password);

    User findByEmail(String email);

    @Query("select r from User r where r.role =?1")
    List<User> findByRole(String role);


    @Query("select a from User a where a.age >=?1")
    List<User> findByAgeGreater(Integer age);
}
