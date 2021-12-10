package com.multi.datasource.repository.shop;

import com.multi.datasource.domain.shop.Shop;
import com.multi.datasource.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
