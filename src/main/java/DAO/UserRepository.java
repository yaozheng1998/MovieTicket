package DAO;

import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author YZ
 * @Date 2018/3/23
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
