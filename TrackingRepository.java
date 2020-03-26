package de.telran.repositiory;

import de.telran.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<Customer,Long> {
}
