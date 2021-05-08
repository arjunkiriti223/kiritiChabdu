package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashokit.entity.ContactEntity;


public interface IContactRepo extends JpaRepository<ContactEntity, Serializable> {

}
