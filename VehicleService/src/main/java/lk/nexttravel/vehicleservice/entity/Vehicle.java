package lk.nexttravel.vehicleservice.entity;

import jakarta.persistence.*;
import lk.nexttravel.vehicleservice.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String brand;
    Category category;
    Fuel fuelType;
    Mode mode;
    double fuel_usage;
    @Lob
    byte[] vehicle_image;
    int seat_capacity;
    Type vehicleType;
    Transmission transmission;
    String driver_name;
    String driver_contact_number;
    @Lob
    byte[] driver_license_image;
    String remarks;
}
