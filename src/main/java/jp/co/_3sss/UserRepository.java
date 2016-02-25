package jp.co._3sss;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginNameAndPassword(String loginName, String password);
}
