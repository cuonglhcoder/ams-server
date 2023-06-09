package ams.repository;

import ams.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account> findByAccountIgnoreCase(String account);
}
