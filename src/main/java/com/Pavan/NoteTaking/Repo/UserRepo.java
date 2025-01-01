package com.Pavan.NoteTaking.Repo;

import com.Pavan.NoteTaking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUsername(String username); // This method is redundant as the primary key is already username.
}
