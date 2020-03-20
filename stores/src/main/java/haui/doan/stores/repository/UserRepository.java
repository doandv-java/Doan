package haui.doan.stores.repository;

import haui.doan.stores.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * The query to get user with user name and deleted
     *
     * @param userName the email of user
     * @param deleted  the flag of user is deleted then 1 or else then 0
     * @return the user information  {@link User}
     */
    User findUserByUserNameIsAndDeleted(String userName, int deleted);

    /**
     * The method to get information user by id
     * if user exists then return data of user else then return null
     *
     * @param id the key of user with long value
     * @return the information of user
     */
    User findUserById(Long id);
}
