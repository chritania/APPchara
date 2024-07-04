package com.conching.APPchara.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conching.APPchara.Model.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{
    Optional<Role> findByName(String name);
}
