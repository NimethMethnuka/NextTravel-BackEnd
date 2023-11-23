package lk.nexttravel.vehicleservice.dto;

import lk.nexttravel.vehicleservice.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {
    String id;
    String brand;
    Category category;
    Fuel fuelType;
    Mode mode;
    double fuel_usage;
    byte[] images;
    int seat_capacity;
    Type vehicleType;
    Transmission transmission;
    String driver_name;
    String driver_contact_number;
    byte[] driver_license_image;
    String remarks;
}
