package lk.nexttravel.vehicleservice.service.impl;

import lk.nexttravel.vehicleservice.dto.VehicleDTO;
import lk.nexttravel.vehicleservice.entity.Vehicle;
import lk.nexttravel.vehicleservice.repo.VehicleRepo;
import lk.nexttravel.vehicleservice.service.custom.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleEntity = modelMapper.map(vehicleDTO, Vehicle.class);
        return modelMapper.map(vehicleRepo.save(vehicleEntity), VehicleDTO.class);

    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        VehicleDTO vehicleDTO = null;
        if (vehicle.isPresent()) {
            vehicleDTO = modelMapper.map(vehicle.get(), VehicleDTO.class);
        }
        return vehicleDTO;
    }

    @Override
    public boolean deleteVehicle(String id) {
        if (getVehicleById(id) != null){
            vehicleRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleEntity = modelMapper.map(vehicleDTO, Vehicle.class);
        return modelMapper.map(vehicleRepo.save(vehicleEntity), VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepo.findAll().stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
    }
}
