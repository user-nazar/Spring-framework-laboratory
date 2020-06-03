package ua.lviv.iot.machinery.spring.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.machinery.spring.manager.Machinery;

@Repository
public interface MachineryRepository extends JpaRepository<Machinery, Integer> {

}