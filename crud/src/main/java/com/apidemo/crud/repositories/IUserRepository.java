package com.apidemo.crud.repositories;

import com.apidemo.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//consultas Querys a base de datos
@Repository

public interface IUserRepository extends JpaRepository<UserModel,Long> {

}
