package lk.nexttravel.vehicleservice.service.custom;

import lk.nexttravel.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    public VehicleDTO saveVehicle(VehicleDTO hotelDTO);

    public VehicleDTO getVehicleById(String id);

    public boolean deleteVehicle(String id);

    public VehicleDTO updateVehicle(VehicleDTO hotelDTO);

    public List<VehicleDTO> getAllVehicles();
}
