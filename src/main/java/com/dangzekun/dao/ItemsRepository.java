package com.dangzekun.dao;

import com.dangzekun.pojo.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Integer> {
    List<Items> findByDetailLike(String detail);
}
