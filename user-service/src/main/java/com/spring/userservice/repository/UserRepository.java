package com.spring.userservice.repository;


import com.spring.userservice.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

//    @Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
//    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
