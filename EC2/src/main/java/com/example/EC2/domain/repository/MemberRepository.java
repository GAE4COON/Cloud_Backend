package com.example.EC2.domain.repository;

import com.example.EC2.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
    List<MemberEntity> findByAPIName(String APIName);

    @Query(value = "SELECT * FROM member_entity WHERE api_name LIKE ?1%", nativeQuery = true)
    List<MemberEntity> findByAPINameStartingWithNative(String prefix);

    List<MemberEntity> findByAPINameContaining(String keyword);



}
