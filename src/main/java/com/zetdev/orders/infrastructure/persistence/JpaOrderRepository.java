package com.zetdev.orders.infrastructure.persistence;

import com.zetdev.orders.domain.model.Order;
import com.zetdev.orders.domain.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;
    private final EntityManager entityManager;

    public JpaOrderRepository(SpringDataOrderRepository springDataOrderRepository, EntityManager entityManager) {
        this.springDataOrderRepository = springDataOrderRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Order save(Order order) {

        OrderEntity entity = entityManager.find(OrderEntity.class, order.getId());

        if (entity == null) {
            entity = OrderMapper.toEntity(order);
            entityManager.persist(entity);
        } else {
            OrderMapper.updateEntity(entity, order);
        }

        return OrderMapper.toDomain(entity);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findById(UUID id) {
        return springDataOrderRepository.findById(id)
                .map(OrderMapper::toDomain);
    }

}


